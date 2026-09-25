/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pai;

import Pai.TelaVenda;
import Pai.TelaEmprestimo;
import Pai.TelaLogin;
import javax.swing.table.DefaultTableModel;
import java.sql.*; // classes de banco 
import conexao.conexao; // importa a classe conexao com o banco
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Admin
 */



// janela swing que herda de JFrame
public class TelaCadastrar extends javax.swing.JFrame {
  //objeto criado para acessar statement e resultset
    conexao con_cliente;
          
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaCadastrar.class.getName());

    /**
     * Creates new form Tela1
     */
    public TelaCadastrar() {
        initComponents();
        con_cliente = new conexao(); //cria o objeto de conexao 
        con_cliente.conecta(); //efetivamente conecta ao banco  
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        con_cliente.executaSQL("select * from tbclientes order by cod"); // busca todos os clientes ordenados pelo código
preencherTabela(); // joga o resultado da consulta dentro da JTable
posicionarRegistro();// posiciona o cursor do resultset no 1º registro e mostra nos campos de texto
jTable1.setAutoCreateRowSorter(true);// permite ordenar a tabela clicando no cabeçalho das colunas
    }
    //define a grid, tamamho qeu vai ser ocupado em pixeis , o nome , email e etc...
public void preencherTabela() {
//Define a largura preferida de cada coluna da tabela (código, nome, data, telefone, email).
    jTable1.getColumnModel().getColumn(0).setPreferredWidth(4);
    jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
    jTable1.getColumnModel().getColumn(2).setPreferredWidth(11);
    jTable1.getColumnModel().getColumn(3).setPreferredWidth(4);
    jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);

    //Pega o modelo de dados da tabela e zera as linhas (limpa a grid antes de repopular — evita duplicar registros toda vez que o método é chamado).
    DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
    modelo.setNumRows(0);

    try {
//Move o cursor do ResultSet para antes do primeiro registro, para garantir que o while abaixo comece do início.
        con_cliente.resultset.beforeFirst();
//Percorre linha por linha do resultado do banco e adiciona cada registro como uma nova linha na JTable.
        while (con_cliente.resultset.next()) {

            modelo.addRow(new Object[]{
              con_cliente.resultset.getString("cod")
                    ,con_cliente.resultset.getString("nome")
                    ,con_cliente.resultset.getString("dt_nasc"
                    ),con_cliente.resultset.getString("telefone")
                    , con_cliente.resultset.getString("email")
            });
        }
//mostra uma mensagem de erro
    } catch (SQLException erro) {
      JOptionPane.showMessageDialog(null,"\n Erro ao listar dados da tabela!! :\n "+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        
    }
}
public void posicionarRegistro() {
    try {
        con_cliente.resultset.first(); // posiciona no 1º registro da tabela
        mostrar_Dados(); // chama o método que irá buscar o dado da tabela
    } catch (SQLException erro) {
       JOptionPane.showMessageDialog(null,"Não foi possível posicionar no primeiro registro: "+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
    }
}
//mostra os registros no campo de texto
public void mostrar_Dados() {
    try {
//Pega os valores da linha atual do resultset (posição atual do cursor) e joga cada valor no campo de texto correspondente.
        codigot.setText(con_cliente.resultset.getString("cod")); // Associar a caixa de texto ao campo cod
        nomet.setText(con_cliente.resultset.getString("nome")); // Associar a caixa de texto ao campo nome
        datat.setText(con_cliente.resultset.getString("dt_nasc"));
        telefonet.setText(con_cliente.resultset.getString("telefone"));
        emailt.setText(con_cliente.resultset.getString("email"));

    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null,"Não localizou dados: "+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
    }
}private void tblclientesMouseClicked(java.awt.event.MouseEvent evt) {

    //Quando o usuário clica em uma linha da grid: pega o índice da linha selecionada (getSelectedRow())
    //e copia o valor de cada coluna dessa linha para os campos de texto (getValueAt(linha, coluna)).
    
    int linha_selecionada = jTable1.getSelectedRow();

    codigot.setText(jTable1.getValueAt(linha_selecionada, 0).toString());
    nomet.setText(jTable1.getValueAt(linha_selecionada, 1).toString());
    datat.setText(jTable1.getValueAt(linha_selecionada, 2).toString());
    telefonet.setText(jTable1.getValueAt(linha_selecionada, 3).toString());
    emailt.setText(jTable1.getValueAt(linha_selecionada, 4).toString());

}
private void tblClientesKeyPressed(java.awt.event.KeyEvent evt) {

    // evento que sincroniza a grid com as setas do teclado
     //Quando o usuário clica em uma linha da grid: pega o índice da linha selecionada (getSelectedRow())
    //e copia o valor de cada coluna dessa linha para os campos de texto (getValueAt(linha, coluna)).

    int linha_selecionada = jTable1.getSelectedRow();

    codigot.setText(jTable1.getValueAt(linha_selecionada, 0).toString());
    nomet.setText(jTable1.getValueAt(linha_selecionada, 1).toString());
    datat.setText(jTable1.getValueAt(linha_selecionada, 2).toString());
    telefonet.setText(jTable1.getValueAt(linha_selecionada, 3).toString());
    emailt.setText(jTable1.getValueAt(linha_selecionada, 4).toString());

}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        codigo = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();
        data = new javax.swing.JLabel();
        telefone = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        codigot = new javax.swing.JTextField();
        nomet = new javax.swing.JTextField();
        datat = new javax.swing.JTextField();
        telefonet = new javax.swing.JTextField();
        emailt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnUtimo = new javax.swing.JButton();
        Cadastrar = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Data Nascimento", "Telefone", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        codigo.setText("Código:");

        nome.setText("Nome:");

        data.setText("Data Nascimento:");

        telefone.setText("Telefone:");

        email.setText("Email");

        emailt.addActionListener(this::emailtActionPerformed);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pai/Previous record.gif"))); // NOI18N
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pai/Playback.gif"))); // NOI18N
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pai/Play.gif"))); // NOI18N
        jButton3.addActionListener(this::jButton3ActionPerformed);

        btnUtimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pai/last recor.gif"))); // NOI18N
        btnUtimo.addActionListener(this::btnUtimoActionPerformed);

        Cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pai/Save.gif"))); // NOI18N
        Cadastrar.addActionListener(this::CadastrarActionPerformed);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pai/Add.gif"))); // NOI18N
        jButton7.addActionListener(this::jButton7ActionPerformed);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pai/Delete.gif"))); // NOI18N
        btnExcluir.addActionListener(this::btnExcluirActionPerformed);

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pai/Notes.gif"))); // NOI18N
        btnAlterar.addActionListener(this::btnAlterarActionPerformed);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tela cadastrar", "Tela emprestimo", "Tela venda", "Tela login", "Cadastrar livro", " " }));
        jComboBox1.addActionListener(this::jComboBox1ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnUtimo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(codigo)
                                    .addComponent(nome)
                                    .addComponent(data)
                                    .addComponent(telefone)
                                    .addComponent(email))
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nomet)
                                    .addComponent(datat)
                                    .addComponent(telefonet)
                                    .addComponent(emailt, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                                    .addComponent(codigot))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigo)
                    .addComponent(codigot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome)
                    .addComponent(nomet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(data)
                    .addComponent(datat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefone)
                    .addComponent(telefonet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email)
                    .addComponent(emailt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Cadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUtimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            //volta para o primeiro registro
        con_cliente.resultset.first();
        mostrar_Dados();
    } catch(SQLException erro){
        JOptionPane.showMessageDialog(null,"Não foi possível acessar o primeiro registro: "+erro);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            //volta para o registro anterior
        con_cliente.resultset.previous();
        mostrar_Dados();
    } catch(SQLException erro){
        JOptionPane.showMessageDialog(null,"Não foi possível posicionar no registro anterior: "+erro);
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            //vai para o proximo registro
        con_cliente.resultset.next();
        mostrar_Dados();
    } catch(SQLException erro){
        JOptionPane.showMessageDialog(null,"Não foi possível posicionar no próximo registro: "+erro);
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnUtimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUtimoActionPerformed
 
        try {
            //vai para o ultimo registro
        con_cliente.resultset.last();
        mostrar_Dados();
    } catch(SQLException erro){
        JOptionPane.showMessageDialog(null,"Não foi possível posicionar no último registro: "+erro);
    }        // TODO add your handling code here:
       
    }//GEN-LAST:event_btnUtimoActionPerformed
//limpa os campos e coloca o foco no campo codigo
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
codigot.setText("");
        nomet.setText("");
        datat.setText("");
        telefonet.setText("");
        emailt.setText("");
        codigot.setText("");
        codigot.requestFocus();
                // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
//Captura os valores dos campos
String nome = nomet.getText();
String data_nasc = datat.getText();
String telefone = telefonet.getText();
String email = emailt.getText(); 
       
String sql="SELECT * FROM tbAlugar";
try {
    //Mostra um popup de confirmação (Sim/Não) antes de excluir. resposta guarda 0 (Sim) ou 1 (Não).
    int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja excluir o registro: ","Confirmar Exclusão", JOptionPane.YES_NO_OPTION,3);
    //Se o usuário confirmou (0 = Yes), monta o comando DELETE usando o código exibido no campo codigot e executa no banco. 
    //executeUpdate retorna o número de linhas afetadas.
    if (resposta==0){
        sql = "delete from tbclientes where cod = " + codigot.getText();
        int excluir = con_cliente.statement.executeUpdate(sql);
        
        //Se exatamente 1 linha foi excluída, avisa sucesso e refaz a consulta inteira (select *), reposiciona no primeiro registro,
        //repopula a tabela e os campos. Se excluir não for 1 (0 linhas afetadas, ou seja, o código não existia), a mensagem diz "operação cancelada"
        
        if (excluir==1){
            JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso!!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
            con_cliente.executaSQL("select * from tbclientes order by cod");
            con_cliente.resultset.first();
            preencherTabela();
            posicionarRegistro();
        }
        else{
            JOptionPane.showMessageDialog(null,"Operação cancelada pelo usuário!!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}catch (SQLException excecao){
    JOptionPane.showMessageDialog(null,"Erro na exclusão: "+excecao,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
}

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarActionPerformed
//guarda o que o usuraio digitou em 4 variaveis
String nome = nomet.getText();
String data_nasc = datat.getText();
String telefone = telefonet.getText();
String email = emailt.getText();

try {
    //coloca as informações digitadas no banco de dados
String insert_sql = "INSERT INTO tbclientes (nome, telefone, email, dt_nasc) VALUES ('" + nome + "','" + telefone + "','" + email + "','" + data_nasc + "')"; con_cliente.statement.executeUpdate(insert_sql);
JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso !", "Menssagem do programa",JOptionPane.INFORMATION_MESSAGE);
con_cliente.executaSQL("select * from tbclientes order by cod");
//volta para o primeiro registro
con_cliente.resultset.first();
preencherTabela();
mostrar_Dados();
} catch(SQLException erroSQL) {
JOptionPane.showMessageDialog(null, "\n erro na gravação :\n " + erroSQL, "mensagem do programa ", JOptionPane.INFORMATION_MESSAGE);
}



    }//GEN-LAST:event_CadastrarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed

String nome = nomet.getText();
String data_nasc = datat.getText();
String telefone = telefonet.getText();
String email = emailt.getText();
String sql="";
String msg="";

try {
    // se o campo codigot estiver vazio, entende que é um registro novo e faz INSERT; se tiver um código,
    //faz UPDATE daquele registro específico.
    
    if(codigot.getText().equals("")){
        sql="insert into tbclientes (nome,telefone, email, dt_nasc) values ('" + nome + "','" + telefone + "','" + email + "','" + data_nasc + "')";
        msg="Gravação de um novo registro";
    }else{
        sql="update tbclientes set nome='" + nome + "',telefone='" + telefone + "', email='" + email + "', dt_nasc='" + data_nasc + "' where cod = " + codigot.getText();
        msg="Alteração de registro";
    }
//executa o update
    con_cliente.statement.executeUpdate(sql);
    JOptionPane.showMessageDialog(null,msg+" realizada com sucesso!!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);

    con_cliente.executaSQL("select * from tbclientes order by cod");
    con_cliente.resultset.first();
    preencherTabela();
    mostrar_Dados();

}catch(SQLException errosql){
    JOptionPane.showMessageDialog(null,"\n Erro na gravação :\n "+errosql,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
}



    }//GEN-LAST:event_btnAlterarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

 String opcaoSelecionada = (String) jComboBox1.getSelectedItem();
        
        switch (opcaoSelecionada) {
            case "Tela venda":
                new TelaVenda().setVisible(true);
                dispose();
                break;
            case "Tela emprestimo":
                new TelaEmprestimo().setVisible(true);
                dispose();
                break;
                case "Tela login":
                new TelaLogin().setVisible(true);
                dispose();
                break;
                 case "Cadastrar livro":
                new TelaCadastrarLivro().setVisible(true);
                dispose();
                break;
        }
    
        
   
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new TelaCadastrar().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cadastrar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnUtimo;
    private javax.swing.JLabel codigo;
    private javax.swing.JTextField codigot;
    private javax.swing.JLabel data;
    private javax.swing.JTextField datat;
    private javax.swing.JLabel email;
    private javax.swing.JTextField emailt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel nome;
    private javax.swing.JTextField nomet;
    private javax.swing.JLabel telefone;
    private javax.swing.JTextField telefonet;
    // End of variables declaration//GEN-END:variables
}
