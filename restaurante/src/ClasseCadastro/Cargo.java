/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasseCadastro;

/**
 *
 * @author jmkuntz
 */
public enum Cargo {
    GARCOM("Garçom"), CAIXA("Caixa"), GERENTE("Gerente");
    
    private String cargo;

    private Cargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return cargo;
    }
}
