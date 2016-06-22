/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.mesa;

import modelo.Model;

/**
 *
 * @author junio_000
 */
public interface ServicoMesa extends Model<Mesa>{
    
    public void addMesa();
    
    public Mesa getMesa(int codigo);
}
