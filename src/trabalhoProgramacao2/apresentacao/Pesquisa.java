/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoProgramacao2.apresentacao;

import trabalhoProgramacao2.controle.Usuario;
import trabalhoProgramacao2.modelo.ControllerUsuario;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vanila
 */
public class Pesquisa extends javax.swing.JDialog {

    trabalhoProgramacao2.modelo.ControllerUsuario controleUsario = new ControllerUsuario();
    DefaultTableModel modelo;
    private String NomeUsuarioSelecionado;

    /**
     * Creates new form Pesquisa
     */
    public Pesquisa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        String[] colunas = new String[]{"Login", "Senha", "Cargo"};
        modelo = new DefaultTableModel(null, colunas);
        table.setModel(modelo);
        
        this.setNomeSelecionado("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabelLogin = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        btPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa de Usuário");
        setResizable(false);

        tabelLogin.setText("Login:");

        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Login", "Senha", "Cargo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seleciona(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tabelLogin)
                                .addGap(7, 7, 7)
                                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tabelLogin)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(btPesquisar)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        this.modelo.getDataVector().removeAllElements();

        if (this.controleUsario.listaUsuarioVazia()) {

            Usuario usuarioSelecionado;

            if (!(this.txtLogin.getText().isEmpty())) {

                usuarioSelecionado = this.controleUsario.pesquisarUsuario(this.txtLogin.getText());
                if (!(usuarioSelecionado == null)) {
                    modelo.addRow(new Object[]{usuarioSelecionado.getLogin(), usuarioSelecionado.getSenha(), usuarioSelecionado.getCargo()});
                }
            } else {

                List<Usuario> lista = this.controleUsario.listatodosUsuarios();

                for (int i = 0; i < lista.size(); i++) {

                    modelo.addRow(new Object[]{lista.get(i).getLogin(), lista.get(i).getSenha(), lista.get(i).getCargo()});
                }
            }
        }

    }//GEN-LAST:event_btPesquisarActionPerformed

    private void seleciona(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seleciona

        if (evt.getClickCount() == 1) {

            int selecionado = table.getSelectedRow();

            if (selecionado != -1) {
                this.setNomeSelecionado(table.getValueAt(selecionado, 0).toString());
                this.dispose();

            }
        }
    }//GEN-LAST:event_seleciona

    private void setNomeSelecionado(String nome) {
        this.NomeUsuarioSelecionado = nome;
    }

    public String getNomeSelecionado() {
        return this.NomeUsuarioSelecionado;
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
            java.util.logging.Logger.getLogger(Pesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Pesquisa dialog = new Pesquisa(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btPesquisar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel tabelLogin;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtLogin;
    // End of variables declaration//GEN-END:variables
}
