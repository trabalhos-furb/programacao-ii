/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.produto;

import java.util.Iterator;
import java.util.List;
import modelo.AbstractModel;

class ServicoProdutoImpl extends AbstractModel<Produto> implements ServicoProduto {

    private List<Produto> produtos;

    ServicoProdutoImpl() {
        carregarProdutos();
    }

    @Override
    public void addProduto(int codigo, String descricao, float valor) {
        this.produtos.add(new Produto(codigo, descricao, valor));
    }

    @Override
    public Produto getProduto(int codigo) {
        for (Produto produto : this) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }

    @Override
    public void persistir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<Produto> iterator() {
        return new ProdutoIterator(this.produtos);
    }

    private void carregarProdutos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removerProduto(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existeProduto(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
