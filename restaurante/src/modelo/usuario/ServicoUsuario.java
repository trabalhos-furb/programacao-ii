/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.usuario;

import modelo.Model;

/**
 *
 * @author junio_000
 */
public interface ServicoUsuario extends Model<Usuario>{
    
    public void addUsuario(String login, String senha, Cargo cargo);
    
    public Usuario getUsuario(String nome);
    
    public void removeUsuario(String nome);
    
    public boolean existeUsuario(String nome);
}
