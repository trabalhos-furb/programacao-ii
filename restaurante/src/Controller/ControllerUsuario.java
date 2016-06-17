package Controller;

import ClasseCadastro.Cargo;
import ClasseCadastro.Usuario;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;

public class ControllerUsuario {

    private boolean logado;
    Path verificaSeExiste = Paths.get("./src/Banco de Dados/usuarios.data");
    private HashMap<String, Usuario> listaUsuarios;

    public ControllerUsuario() {
        this.setLogado(false);
        listaUsuarios = new HashMap<>();
        this.carregaListaUsuario();
    }

    public Usuario pesquisarUsuario(String nome) {
        Usuario usuario = listaUsuarios.get(nome);
        return usuario;
    }

    public boolean listaUsuarioVazia() {
        if (listaUsuarios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum usuário cadastrado!!");
            return false;
        }
        return true;
    }

    public List listatodosUsuarios() {
        List<Usuario> lista = new ArrayList<>(listaUsuarios.values());
        return lista;
    }

    public void removeUsuario(String nome) {
        listaUsuarios.remove(nome);
        this.salvarUsuario("REMOVE");
    }

    public void gravarUsuario(String nome, String senha, Cargo cargo) {

        if (listaUsuarios.containsKey(nome)) {
            if (JOptionPane.showConfirmDialog(null, "Deseja realmente alterar os dados?", "Atenção", JOptionPane.YES_NO_OPTION) == 0) {
                listaUsuarios.get(nome).setLogin(nome);
                listaUsuarios.get(nome).setSenha(senha);
                listaUsuarios.get(nome).setCargo(cargo);
                this.salvarUsuario("SALVAR");
            }

        } else {

            Usuario usu = new Usuario(nome, senha, cargo);
            listaUsuarios.put(nome, usu);
            this.salvarUsuario("SALVAR");
        }
    }

    public void salvarUsuario(String opcaoMensagem) {
        try {

            FileOutputStream fout = new FileOutputStream(verificaSeExiste.toString());
            ObjectOutputStream object = new ObjectOutputStream(fout);
            object.writeObject(listaUsuarios);

            object.close();

            if (opcaoMensagem.equals("SALVAR")) {
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Usuário removido!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void carregaListaUsuario() {

        if (Files.exists(verificaSeExiste)) {

            try {

                FileInputStream fin = new FileInputStream(verificaSeExiste.toString());
                ObjectInputStream ois = new ObjectInputStream(fin);

                listaUsuarios = (HashMap) ois.readObject();

                ois.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
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

}
