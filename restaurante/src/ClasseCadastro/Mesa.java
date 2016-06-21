/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasseCadastro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author junio_000
 */
public class Mesa implements Serializable {

    private final int numero;
    private Status status;
    private final List<Pedido> pedidos;

    public Mesa(int numero, Status status) {
        this.numero = numero;
        this.status = status;
        this.pedidos = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void addPedido(Pedido p) {
        pedidos.add(p);
    }
    
    public int getQuantidadePedidos() {
        return this.pedidos.size();
    }
    
    public Pedido getPedido(int numero) {
        return this.pedidos.get(numero);
    }
    
    public double calcularValorTotal() {
        double total = 0;
        for (Pedido produto : pedidos) {
            total += produto.calculaValorTotal();
        }
        return total;
    }

    public void removePedido(int pedido) {
        this.pedidos.remove(pedido);
    }
    
}
