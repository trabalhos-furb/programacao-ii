/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.produto;

import modelo.Model;

/**
 *
 * @author junio_000
 */
public interface ServicoProduto extends Model<Produto> {
    
    public void addProduto(int codigo, String descricao, float valor);
    
    public Produto getProduto(int codigo);
    
    public void removerProduto(int codigo);
    
    public boolean existeProduto(int codigo);
}
