/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.produto;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import modelo.AbstractModel;
import modelo.Persistence;

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
        final Persistence<Produto> instance = Persistence.getInstance();
        instance.save(produtos, "Produtos");
    }

    @Override
    public Iterator<Produto> iterator() {
        return this.produtos.iterator();
    }

    private void carregarProdutos() {
        final Persistence<Produto> instance = Persistence.getInstance();
        this.produtos = instance.load("Produtos");
    }

    @Override
    public void removerProduto(int codigo) {
        for (int i = 0; i < this.produtos.size(); i++) {
            if (this.produtos.get(i).getCodigo() == codigo) {
                this.produtos.remove(i);
                break;
            }
        }
    }

    @Override
    public boolean existeProduto(int codigo) {
        return this.getProduto(codigo) != null;
    }

    @Override
    public Iterator<Produto> getProdutosPorDescricao(String descricao) {
        return this.produtos.stream(). //Transforma a lista em stream
                filter(produto -> produto.getDescricao().contains(descricao)). //Usa lambda expression para filtrar a stream para manter somente os elementos que possuem a descrição informada.
                collect(Collectors.toList()).
                iterator(); //Transforma a stream já filtrada em lista.
    }

    @Override
    public Iterator<Produto> getProdutosPorCodigo(int codigo) {
        return Arrays.asList(this.getProduto(codigo)).iterator();
    }

}
