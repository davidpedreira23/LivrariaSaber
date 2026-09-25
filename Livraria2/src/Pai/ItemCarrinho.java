/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pai;

/**
 *
 * @author David
 */
public class ItemCarrinho {
    int codLivro;
    String titulo;
    double precoUnitario;
    int quantidade;

    public ItemCarrinho(int codLivro, String titulo, double precoUnitario, int quantidade) {
        this.codLivro = codLivro;
        this.titulo = titulo;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
    }

    public double getSubtotal() {
        return precoUnitario * quantidade;
        // TROQUEI O NOME PRINCIPAL DA PASTA
    }
}
