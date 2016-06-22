/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.produto;

import java.util.List;
import modelo.AbstractIterator;

/**
 *
 * @author junio_000
 */
class ProdutoIterator extends AbstractIterator<Produto> {

    public ProdutoIterator(List<Produto> itens) {
        super(itens);
    }

}
