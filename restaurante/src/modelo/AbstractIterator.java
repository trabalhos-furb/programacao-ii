/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author junio_000
 */
public abstract class AbstractIterator<T> implements Iterator<T> {

    private final List<T> itens;
    private int posicaoAtual;

    public AbstractIterator(List<T> itens) {
        this.itens = itens;
        this.posicaoAtual = 0;
    }

    @Override
    public boolean hasNext() {
        return posicaoAtual < itens.size();
    }

    @Override
    public T next() {
        return this.itens.get(posicaoAtual++);
    }
}
