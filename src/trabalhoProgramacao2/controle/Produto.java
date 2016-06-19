/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoProgramacao2.controle;

import java.io.Serializable;

/**
 *
 * @author junio_000
 */
public class Produto implements Serializable{

    private int codigo;
    private String descricao;
    private float valor;

    public Produto(int codigo, String descricao, float valor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

        @Override
	   public String toString() {
    	   return new StringBuffer(" Código : ")
    	   .append(this.codigo)
    	   .append(" Descrição : ")
    	   .append(this.descricao)
           .append(" Valor R$: ")
           .append(this.valor).toString();
	   }

}
