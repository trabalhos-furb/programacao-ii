/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.mesa.ServicoMesa;
import modelo.Pedido;
import modelo.mesa.Status;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import modelo.mesa.FabricaServicoMesa;
import modelo.mesa.Mesa;

/**
 *
 * @author junio_000
 */
public class ControllerMesa {

    private final GridBagConstraints gridConstraints = new GridBagConstraints();
    private int proximoIndiceColuna = 1;
    private final JPanel panelMesas;
    private final JTable tabelaProdutos;
    private JButton selectedButton = null;
    private Mesa mesaSelecionada = null;
    private final JTextField lbValorTotalMesa;
    private final ServicoMesa servicoMesa;

    public ControllerMesa(JPanel panelMesas, JTable tabelaProdutos, JTextField lbValorTotalMesa) {
        this.servicoMesa = FabricaServicoMesa.getServicoMesa();
        this.panelMesas = panelMesas;
        this.tabelaProdutos = tabelaProdutos;
        this.lbValorTotalMesa = lbValorTotalMesa;
        setGridConstraints();
        carregarMesas();
    }

    private void setGridConstraints() {
        gridConstraints.fill = GridBagConstraints.BOTH;
        gridConstraints.ipadx = 45;
        gridConstraints.ipady = 45;
    }

    private void carregarMesas() {
        atualizaMesas();
    }

    private void atualizaMesas() {
        proximoIndiceColuna = 1;
        panelMesas.removeAll();
        for (Mesa mesa : servicoMesa) {
            adicionarBotaoMesa(criarBotao(mesa));
        }
        adicionarBotaoMesa(criarBotaoAdicionar());
        this.panelMesas.revalidate();
        this.panelMesas.repaint();
        this.servicoMesa.persistir();
    }

    private JButton criarBotao(Mesa mesa) {
        JButton jButton = new JButton();
        jButton.setText(String.valueOf(mesa.getNumero()));
        jButton.setFont(new Font(jButton.getFont().getName(), Font.PLAIN, 20));
        jButton.setMinimumSize(new Dimension(45, 45));
        jButton.setMaximumSize(new Dimension(45, 45));
        jButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    showPopupMenu(e);
                }
                setMesaSelecionada((JButton) e.getSource());
                atualizaTabelaProdutos();
                super.mouseClicked(e);
            }
        });
        jButton.setBackground(getCorBotao(mesa.getStatus()));
        return jButton;
    }

    private void showPopupMenu(MouseEvent e) {
        JPopupMenu jPopupMenu = new JPopupMenu("Teste");

        final JMenu statusMenu = new JMenu("Alterar status");

        final JMenuItem menuDisponivel = new JMenuItem("Disponivel");
        menuDisponivel.addActionListener((ActionEvent ae) -> {
            atualizaMesaSelecionada(Status.DISPONIVEL);
        });

        final JMenuItem menuOcupado = new JMenuItem("Ocupado");
        menuOcupado.addActionListener((ActionEvent ae) -> {
            atualizaMesaSelecionada(Status.OCUPADO);
        });

        final JMenuItem menuReservado = new JMenuItem("Reservado");
        menuReservado.addActionListener((ActionEvent ae) -> {
            atualizaMesaSelecionada(Status.RESERVADO);
        });

        statusMenu.add(menuDisponivel);
        statusMenu.add(menuOcupado);
        statusMenu.add(menuReservado);

        jPopupMenu.add(statusMenu);
        jPopupMenu.show((Component) e.getSource(), 0, 0);
    }

    private void atualizaMesaSelecionada(final Status status) {
        mesaSelecionada.setStatus(status);
        setMesaSelecionada(selectedButton);
    }

    private JButton criarBotaoAdicionar() {
        JButton jButton = new JButton();
        jButton.setText("+");
        jButton.setFont(new Font(jButton.getFont().getName(), Font.PLAIN, 20));
        jButton.setMinimumSize(new Dimension(45, 45));
        jButton.setMaximumSize(new Dimension(45, 45));
        jButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                servicoMesa.addMesa();
                atualizaMesas();
                super.mouseClicked(e);
            }
        });
        return jButton;
    }
    
    private void setMesaSelecionada(JButton button) {
        if (selectedButton != null) {
            selectedButton.setBackground(getCorBotao(mesaSelecionada.getStatus()));
        }
        selectedButton = button;
        mesaSelecionada = servicoMesa.getMesa(Integer.valueOf(selectedButton.getText()));
        selectedButton.setBackground(getCorBotaoSelecionado(mesaSelecionada.getStatus()));
    }

    private void atualizaTabelaProdutos() {
        final DefaultTableModel tableModel = (DefaultTableModel) tabelaProdutos.getModel();
        tableModel.setRowCount(0);
        for (int i = 0; i < mesaSelecionada.getQuantidadePedidos(); i++) {
            Pedido pedido = mesaSelecionada.getPedido(i);
            tableModel.addRow(new Object[]{i+1, pedido.getCodigoProduto(), pedido.getDescricaoProduto(), pedido.getQuantidade(), pedido.getValorUnitario(), pedido.calculaValorTotal()});
        }
        lbValorTotalMesa.setText(String.valueOf(mesaSelecionada.calcularValorTotal()));
    }

    private Color getCorBotao(Status status) {
        switch (status) {
            case OCUPADO:
                return Color.RED;
            case DISPONIVEL:
                return Color.BLUE;
            case RESERVADO:
                return Color.YELLOW;
        }
        return null;
    }
    
    private Color getCorBotaoSelecionado(Status status) {
        switch (status) {
            case OCUPADO:
                return Color.RED.darker().darker().darker();
            case DISPONIVEL:
                return Color.BLUE.darker().darker().darker();
            case RESERVADO:
                return Color.YELLOW.darker().darker().darker();
        }
        return null;
    }

    private void adicionarBotaoMesa(JButton botao) {
        gridConstraints.gridwidth = proximoIndiceColuna % 5; //Somente 5 colunas
        panelMesas.add(botao, gridConstraints);
        proximoIndiceColuna++;
    }

    public void addPedido(Pedido pedido) {
        if (mesaSelecionada == null) {
            JOptionPane.showMessageDialog(null, "É preciso selecionar uma mesa!");
        }
        mesaSelecionada.addPedido(pedido);
        atualizaTabelaProdutos();
        atualizaMesas();
    }

    public void removerPedido() {
        DefaultTableModel model =  (DefaultTableModel) tabelaProdutos.getModel();
        int pedido = (int) model.getValueAt(tabelaProdutos.getSelectedRow(), 0);
        model.removeRow(tabelaProdutos.getSelectedRow());
        mesaSelecionada.removePedido(pedido);
    }
    
    public double getValorTotalMesa() {
        return mesaSelecionada.calcularValorTotal();
    }

    public void fecharMesa() {
        mesaSelecionada.limparPedidos();
        atualizaMesas();
        atualizaTabelaProdutos();
    }
}
