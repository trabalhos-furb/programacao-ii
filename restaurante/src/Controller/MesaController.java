/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ClasseCadastro.Mesa;
import ClasseCadastro.Pedido;
import ClasseCadastro.Persistence;
import ClasseCadastro.Status;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author junio_000
 */
public class MesaController {

    private List<Mesa> mesas;
    private final GridBagConstraints gridConstraints = new GridBagConstraints();
    private int proximoIndiceColuna = 1;
    private final JPanel panelMesas;
    private final Persistence<Mesa> persistence = new Persistence<>();
    private final JTable tabelaProdutos;
    private JButton selectedButton = null;
    private Mesa mesaSelecionada = null;
    private final JTextField lbValorTotalMesa;

    public MesaController(JPanel panelMesas, JTable tabelaProdutos, JTextField lbValorTotalMesa) {
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
        this.mesas = persistence.load("Mesas");
        atualizaMesas();
    }

    private void atualizaMesas() {
        proximoIndiceColuna = 1;
        panelMesas.removeAll();
        for (Mesa mesa : mesas) {
            adicionarBotaoMesa(criarBotao(mesa));
        }
        adicionarBotaoMesa(criarBotaoAdicionar());
        this.panelMesas.revalidate();
        this.panelMesas.repaint();
        persistence.save(mesas, "Mesas");
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
                setMesaSelecionada((JButton) e.getSource());
                atualizaTabelaProdutos();
                super.mouseClicked(e);
            }
        });
        jButton.setBackground(getCorBotao(mesa.getStatus()));
        return jButton;
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
                mesas.add(new Mesa(mesas.size()+1, Status.DISPONIVEL));
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
        mesaSelecionada = getMesa(Integer.valueOf(selectedButton.getText()));
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

    private Mesa getMesa(int numeroMesa) {
        for (Mesa mesa : mesas) {
            if (mesa.getNumero() == numeroMesa) {
                return mesa;
            }
        }
        return null;
    }

    private Color getCorBotao(Status status) {
        switch (status) {
            case OCUPADO:
                return Color.RED;
            case DISPONIVEL:
                return Color.BLUE;
            default:
                return Color.YELLOW;
        }
    }
    
    private Color getCorBotaoSelecionado(Status status) {
        switch (status) {
            case OCUPADO:
                return Color.RED.darker().darker().darker();
            case DISPONIVEL:
                return Color.BLUE.darker().darker().darker();
            default:
                return Color.YELLOW.darker().darker().darker();
        }
    }

    private void adicionarBotaoMesa(JButton botao) {
        gridConstraints.gridwidth = proximoIndiceColuna % 5; //Somente 5 colunas
        panelMesas.add(botao, gridConstraints);
        proximoIndiceColuna++;
    }

    public void addPedido(Pedido pedido) {
        mesaSelecionada.addPedido(pedido);
        atualizaTabelaProdutos();
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
}
