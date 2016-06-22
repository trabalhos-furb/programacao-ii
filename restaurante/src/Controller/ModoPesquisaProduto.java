/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author junio_000
 */
public enum ModoPesquisaProduto {

    TODOS("Todos"), CODIGO("Código"), DESCRICAO("Descrição");

    private final String modoPesquisa;

    private ModoPesquisaProduto(String modoPesquisa) {
        this.modoPesquisa = modoPesquisa;
    }

    @Override
    public String toString() {
        return this.modoPesquisa;
    }
}
