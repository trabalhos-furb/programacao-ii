package modelo.usuario;

import java.io.Serializable;

/**
 *
 * @author Vanila
 */
public class Usuario implements Serializable {

    private String login;
    private String senha;
    private Cargo cargo;

    Usuario() {

        this.setLogin(null);
        this.setSenha(null);
        this.setCargo(Cargo.GARCOM);

    }

    public Usuario(String login, String senha, Cargo cargo) {
        this.setLogin(login);
        this.setSenha(senha);
        this.setCargo(cargo);
    }

    /**
     * @return the lo gin
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the cargo
     */
    public Cargo getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return new StringBuffer(" Login : ")
                .append(this.login)
                .append(" Senha : ")
                .append(this.senha)
                .append(" Cargo: ")
                .append(this.cargo).toString();
    }

}
