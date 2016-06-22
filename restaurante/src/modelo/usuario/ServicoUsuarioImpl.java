/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.usuario;

import java.util.Iterator;
import java.util.Map;
import modelo.AbstractModel;
import modelo.Persistence;

/**
 *
 * @author junio_000
 */
class ServicoUsuarioImpl extends AbstractModel<Usuario> implements ServicoUsuario {

    private Map<String, Usuario> usuarios;

    ServicoUsuarioImpl() {
        carregarUsuarios();
    }

    @Override
    public void persistir() {
        final Persistence<Usuario> instance = Persistence.getInstance();
        instance.save(usuarios, "Usuarios");
    }

    private void carregarUsuarios() {
        final Persistence<Usuario> instance = Persistence.getInstance();
        this.usuarios = instance.loadMap("Usuarios");
    }

    @Override
    public void addUsuario(String login, String senha, Cargo cargo) {
        this.usuarios.put(login.toUpperCase(), new Usuario(login, senha, cargo));
        this.notifyListeners();
    }

    @Override
    public Usuario getUsuario(String nome) {
        return usuarios.get(nome.toUpperCase());
    }

    @Override
    public Iterator<Usuario> iterator() {
        return this.usuarios.values().iterator();
    }

    @Override
    public void removeUsuario(String nome) {
        this.usuarios.remove(nome.toUpperCase());
    }

    @Override
    public boolean existeUsuario(String nome) {
        return this.getUsuario(nome.toUpperCase()) != null;
    }
}
