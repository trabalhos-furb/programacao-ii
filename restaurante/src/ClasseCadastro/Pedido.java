/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasseCadastro;

import java.io.Serializable;

/**
 *
 * @author junio_000
 */
public class Pedido implements Serializable {

    private final int numero;
    private final Produto produto;
    private int quantidade;

    public Pedido(int numero, Produto produto, int quantidade) {
        this.numero = numero;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Pedido(int numero, Produto produto) {
        this(numero, produto, 1);
    }

    public int getNumero() {
        return numero;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double calculaValorTotal() {
        return this.produto.getValor() * this.quantidade;
    }
    
    public double getValorUnitario() {
        return this.produto.getValor();
    }
    
    public String getDescricaoProduto() {
        return this.produto.getDescricao();
    }

    public int getCodigoProduto() {
        return this.produto.getCodigo();
    }
}
