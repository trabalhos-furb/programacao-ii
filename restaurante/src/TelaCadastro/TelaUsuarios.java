/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelaCadastro;

import ClasseCadastro.Cargo;
import ClasseCadastro.Usuario;
import Pesquisa.Pesquisa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static trabalhoprogramacao2.TelaPrincipal.listaUsuarios;
import static trabalhoprogramacao2.TelaPrincipal.usuarioSelec;

/**
 *
 * @author Vanila
 */
public class TelaUsuarios extends javax.swing.JDialog {

    Path verificaSeExiste = Paths.get("C:\\Users\\Public\\Documents\\usuarios.data");
    boolean editar = false;

    /**
     * Creates new form TelaUsuarios
     */
    public TelaUsuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
               
        this.iniciaSistema();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ComboboxCargo = new javax.swing.JComboBox<>(ClasseCadastro.Cargo.values());
        LabelCargo = new javax.swing.JLabel();
        BtEditar = new javax.swing.JButton();
        labelLogin = new javax.swing.JLabel();
        BtPesquisar = new javax.swing.JButton();
        TxtLogin = new javax.swing.JTextField();
        labelSenha = new javax.swing.JLabel();
        BtExcluir = new javax.swing.JButton();
        TxtSenha = new javax.swing.JPasswordField();
        BtNovo = new javax.swing.JButton();
        TxtConfirmaSenha = new javax.swing.JPasswordField();
        LabelConfirmaSenha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Usuário");

        ComboboxCargo.setEditable(true);
        ComboboxCargo.setEnabled(false);

        LabelCargo.setText("Cargo:");

        BtEditar.setText("Editar");
        BtEditar.setAlignmentY(0.0F);
        BtEditar.setEnabled(false);
        BtEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEditarActionPerformed(evt);
            }
        });

        labelLogin.setText("Login:");

        BtPesquisar.setText("Pesquisar");
        BtPesquisar.setEnabled(false);
        BtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtPesquisarActionPerformed(evt);
            }
        });

        TxtLogin.setEnabled(false);

        labelSenha.setText("Senha:");

        BtExcluir.setText("Excluir");
        BtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtExcluirActionPerformed(evt);
            }
        });

        TxtSenha.setEnabled(false);

        BtNovo.setText("Novo");
        BtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtNovoActionPerformed(evt);
            }
        });

        TxtConfirmaSenha.setEnabled(false);

        LabelConfirmaSenha.setText("Confirme a senha:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboboxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelSenha)
                            .addComponent(LabelConfirmaSenha)
                            .addComponent(LabelCargo)
                            .addComponent(labelLogin))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TxtLogin, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtSenha)
                            .addComponent(TxtConfirmaSenha, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(BtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(BtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(BtEditar)
                                .addGap(1, 1, 1)
                                .addComponent(BtPesquisar)))
                        .addGap(10, 10, 10))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(labelLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelConfirmaSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtConfirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(LabelCargo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboboxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(BtPesquisar)
                    .addComponent(BtExcluir)
                    .addComponent(BtNovo)
                    .addComponent(BtEditar))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtNovoActionPerformed
        this.configuraBotao(1);
    }//GEN-LAST:event_BtNovoActionPerformed

    private void BtEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEditarActionPerformed
        this.configuraBotao(1);
        this.editar = true;
    }//GEN-LAST:event_BtEditarActionPerformed

    private void BtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtExcluirActionPerformed
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getLogin().equals(TxtLogin.getText())
                    && listaUsuarios.get(i).getSenha().equals(TxtSenha.getText())) {
                listaUsuarios.remove(i);
                if (this.salvarUsuario()) {
                    TxtLogin.setText(null);
                    TxtSenha.setText(null);
                    TxtConfirmaSenha.setText(null);
                    JOptionPane.showMessageDialog(null, "Usuário removido!");
                }
            }
        }
    }//GEN-LAST:event_BtExcluirActionPerformed

    private void BtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtPesquisarActionPerformed
        Pesquisa pesquisar = new Pesquisa(null, true, 1);

        pesquisar.setLocationRelativeTo(null);
        pesquisar.setModal(true);
        pesquisar.setVisible(true);

        if (!(usuarioSelec.getLogin().isEmpty() && usuarioSelec.getSenha().isEmpty())) {
            TxtLogin.setText(usuarioSelec.getLogin());
            TxtSenha.setText(usuarioSelec.getSenha());
            ComboboxCargo.setSelectedItem(usuarioSelec.getCargo());

            this.BtEditar.setEnabled(true);
        }

    }//GEN-LAST:event_BtPesquisarActionPerformed
    private void BtgravarActionPerformed(java.awt.event.ActionEvent evt) {

        if (this.TxtSenha.getText().equals(this.TxtConfirmaSenha.getText())) {

            if (this.TxtLogin.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Por favor para prosegui insira um login válido");

            } else if (this.TxtSenha.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Por favor para prosegui insira uma senha válida");

            } else {

                if (editar == true) {
                    for (int i = 0; i < listaUsuarios.size(); i++) {

                        if (usuarioSelec.getLogin().equals(listaUsuarios.get(i).getLogin())
                                && usuarioSelec.getSenha().equals(listaUsuarios.get(i).getSenha())) {

                            listaUsuarios.get(i).setLogin(TxtLogin.getText());
                            listaUsuarios.get(i).setSenha(TxtSenha.getText());
                            listaUsuarios.get(i).setCargo((Cargo) ComboboxCargo.getSelectedItem());
                            this.editar = false;
                            break;

                        }

                    }
                } else {
                    Usuario usu = new Usuario(this.TxtLogin.getText(), this.TxtSenha.getText(), (Cargo) this.ComboboxCargo.getSelectedItem());
                    listaUsuarios.add(usu);
                }

                if (this.salvarUsuario() == true) {
                    TxtLogin.setText(null);
                    TxtSenha.setText(null);
                    TxtConfirmaSenha.setText(null);
                    JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Senhas diferentes por favor verifique!.");
        }

    }

    private void BtCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        if (JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar?", "Atenção", JOptionPane.YES_NO_OPTION) == 0) {
            TxtLogin.setText(null);
            TxtSenha.setText(null);
            TxtConfirmaSenha.setText(null);
            configuraBotao(2);
        }
    }

    private void configuraBotao(int opcao) {

        if (opcao == 1) {

            this.BtPesquisar.setEnabled(false);
            this.TxtSenha.setEnabled(true);
            this.TxtLogin.setEnabled(true);
            this.TxtConfirmaSenha.setEnabled(true);
            this.ComboboxCargo.setEnabled(true);
         
            this.BtNovo.removeActionListener(this.BtNovo.getActionListeners()[0]);
            this.BtNovo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    BtgravarActionPerformed(e);
                }
            });
            this.BtNovo.setText("Gravar");

            this.BtExcluir.removeActionListener(this.BtExcluir.getActionListeners()[0]);
            this.BtExcluir.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    BtCancelarActionPerformed(e);
                }
            });

            this.BtExcluir.setText("Cancelar");

        } else {

            this.BtPesquisar.setEnabled(true);
            this.TxtSenha.setEnabled(false);
            this.TxtLogin.setEnabled(false);
            this.TxtConfirmaSenha.setEnabled(false);
            this.ComboboxCargo.setEnabled(false);

            this.BtNovo.removeActionListener(this.BtNovo.getActionListeners()[0]);
            this.BtNovo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    BtNovoActionPerformed(e);
                }
            });
            this.BtNovo.setText("Novo");

            this.BtExcluir.removeActionListener(this.BtExcluir.getActionListeners()[0]);
            this.BtExcluir.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    BtExcluirActionPerformed(e);
                }
            });
            this.BtExcluir.setText("Excluir");

        }

    }

    public void iniciaSistema() {

        if (Files.exists(verificaSeExiste)) {

            try {
                /*
		    * Responsável por carregar o arquivo address.ser
		    * */
                FileInputStream fin = new FileInputStream(verificaSeExiste.toString());

                /*
		    * Responsável por ler o objeto referente ao arquivo
		    * */
                ObjectInputStream ois = new ObjectInputStream(fin);

                /*
		    * Aqui a mágica é feita, onde os bytes presentes no arquivo address.ser
		    * são convertidos em uma instância de Address.
		    * */
                listaUsuarios = (ArrayList) ois.readObject();
                ois.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public boolean salvarUsuario() {
        try {


            /*
		 * A Classe FileOutputStream é responsável por criar
		 * o arquivo fisicamente no disco, assim poderemos realizar a 
		 * escrita neste. 
		 * */
            FileOutputStream fout = new FileOutputStream(verificaSeExiste.toString());

            /*
		 * A Classe ObjectOutputStream escreve os objetos no FileOutputStream
		 * */
            ObjectOutputStream object = new ObjectOutputStream(fout);

            /*
		 * Veja aqui a mágica ocorrendo: Estamos gravando um objeto 
		 * do tipo Address no arquivo address.ser. Atenção: O nosso 
		 * objeto Address que está sendo gravado, já é gravado de forma 
		 * serializada
		 * */
            object.writeObject(listaUsuarios);

            object.close();

            this.configuraBotao(2);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaUsuarios dialog = new TelaUsuarios(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtEditar;
    private javax.swing.JButton BtExcluir;
    public javax.swing.JButton BtNovo;
    public javax.swing.JButton BtPesquisar;
    public javax.swing.JComboBox<ClasseCadastro.Cargo> ComboboxCargo;
    private javax.swing.JLabel LabelCargo;
    private javax.swing.JLabel LabelConfirmaSenha;
    public javax.swing.JPasswordField TxtConfirmaSenha;
    public javax.swing.JTextField TxtLogin;
    public javax.swing.JPasswordField TxtSenha;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JLabel labelSenha;
    // End of variables declaration//GEN-END:variables
}
