/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import javax.swing.JOptionPane;
import java.sql.*;  
/**
 *
 * @author Admin
 */
public class conexao {
    
    final private String driver = "com.mysql.jdbc.Driver";
    final private String url = "jdbc:mysql://127.0.0.1/livraria";
    final private String usuario = "root";
    final private String senha = "";
    private Connection conexao;
    public Statement statement;
    public ResultSet resultset;
    public PreparedStatement preparaSQL(String sql) throws SQLException {
    return conexao.prepareStatement(sql);
}
    public boolean conecta() {   // metodo do tipo boolean responsavel pela conexão
    boolean result = true;

    try {                    // tratamento de erros 
        Class.forName(driver);
        conexao = DriverManager.getConnection(url, usuario, senha); // conexao = gerenciamento de 

        JOptionPane.showMessageDialog(
            null,
            "Conexão estabelecida",
            "Mensagem do Programa",
            JOptionPane.INFORMATION_MESSAGE
        );

    } catch (ClassNotFoundException Driver) {

        JOptionPane.showMessageDialog(
            null,
            "Driver não localizado" + Driver,
            "Mensagem do Programa",
            JOptionPane.INFORMATION_MESSAGE
        );

        result = false;
        
    } catch (SQLException Fonte) {

        JOptionPane.showMessageDialog(
            null,
            "Fonte de dados não localizada" + Fonte,
            "Mensagem do Programa",
            JOptionPane.INFORMATION_MESSAGE
        );

        result = false;
    }

    return result;
}

public void desconecta() {

    try {

        conexao.close();

        JOptionPane.showMessageDialog(
            null,
            "Conexão com o banco fechada",
            "Mensagem do Programa",
            JOptionPane.INFORMATION_MESSAGE
        );

    } catch (SQLException fecha) {

    }
}

public void executaSQL(String sql) {

    try {

        statement = conexao.createStatement(
            ResultSet.TYPE_SCROLL_SENSITIVE,
            ResultSet.CONCUR_READ_ONLY
        );

        resultset = statement.executeQuery(sql);

    } catch (SQLException excecao) {

        JOptionPane.showMessageDialog(
            null,
            "Erro no comando SQL! \n Erro: " + excecao,
            "Mensagem do Programa",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
}
