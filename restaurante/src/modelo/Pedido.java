/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.produto.Produto;
import java.io.Serializable;

/**
 *
 * @author junio_000
 */
public class Pedido implements Serializable {

    private final Produto produto;
    private int quantidade;

    public Pedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
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
