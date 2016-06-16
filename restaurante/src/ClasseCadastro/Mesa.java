/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasseCadastro;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author junio_000
 */
public class Mesa {

    private int numero;
    private Status status;
    private final List<Produto> produtos;

    public Mesa(int numero, Status status) {
        this.numero = numero;
        this.status = status;
        this.produtos = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void addProduto(Produto p) {
        produtos.add(p);
    }
    
    public double getValorTotal() {
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.getValor();
        }
        return total;
    }
    
}
