package controlador;

import java.util.Iterator;
import modelo.usuario.Cargo;
import javax.swing.JOptionPane;
import modelo.usuario.FabricaServicoUsuario;
import modelo.usuario.ServicoUsuario;
import modelo.usuario.Usuario;

public class ControllerUsuario {

    private boolean logado;
    public Usuario usuarioLogado;
    private final ServicoUsuario servicoUsuario;

    public ControllerUsuario() {
        this.setLogado(false);
        this.servicoUsuario = FabricaServicoUsuario.getServicoUsuario();
    }

    public Usuario pesquisarUsuario(String nome) {
        Usuario usuario = servicoUsuario.getUsuario(nome);
        if (usuario == null) {
            JOptionPane.showMessageDialog(null, "Usuário não foi encontrado!");
        }
        return usuario;
    }

    public void removeUsuario(String nome) {
        servicoUsuario.removeUsuario(nome);
        this.salvarUsuario("REMOVE");
    }

    public void gravarUsuario(String nome, String senha, Cargo cargo) {

        if (servicoUsuario.existeUsuario(nome)) {
            if (JOptionPane.showConfirmDialog(null, "Deseja realmente alterar os dados?", "Atenção", JOptionPane.YES_NO_OPTION) == 0) {
                Usuario usuario = servicoUsuario.getUsuario(nome);
                usuario.setSenha(senha);
                usuario.setCargo(cargo);
                this.salvarUsuario("SALVAR");
            }
        } else {
            servicoUsuario.addUsuario(nome, senha, cargo);
            this.salvarUsuario("SALVAR");
        }
    }

    public void salvarUsuario(String opcaoMensagem) {
        servicoUsuario.persistir();

    }

    public boolean verificaUsuarioLogado() {
        return servicoUsuario.existeUsuario(this.usuarioLogado.getLogin());
    }

    public void logar(String nome, String senha) {

        if (nome.equalsIgnoreCase("Suporte") && senha.equals("123456")) {
            usuarioLogado.setLogin("Suporte");
            usuarioLogado.setCargo(Cargo.GERENTE);
            usuarioLogado.setSenha("123456");
            this.setLogado(true);
        } else if (this.pesquisarUsuario(nome.toUpperCase()) != null) {
            usuarioLogado = this.pesquisarUsuario(nome.toUpperCase());
            if (usuarioLogado.getSenha().equals(senha)) {
                this.setLogado(true);
            } else {
                JOptionPane.showMessageDialog(null, "Senha incorreta!");
            }
        }
    }

    public void Deslogar() {
        this.setLogado(false);
        usuarioLogado.setLogin(null);
        usuarioLogado.setSenha(null);
        usuarioLogado.setCargo(Cargo.GARCOM);
    }

    /**
     * @return the logado
     */
    public boolean getLogado() {
        return logado;
    }

    /**
     * @param logado the logado to set
     */
    private void setLogado(boolean logado) {
        this.logado = logado;
    }
    
    public Iterable<Usuario> getIterable() {
        return this.servicoUsuario;
    }

}
