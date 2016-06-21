/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ClasseCadastro.Mesa;
import ClasseCadastro.Persistence;
import ClasseCadastro.Status;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author junio_000
 */
public class MesaController {

    private List<Mesa> mesas = new ArrayList<>();
    private GridBagConstraints gridConstraints = new GridBagConstraints();
    private int proximoIndiceColuna = 1;
    private final JPanel panelMesas;
    private Persistence<Mesa> persistence = new Persistence<>();

    public MesaController(JPanel panelMesas) {
        this.panelMesas = panelMesas;
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
        for (Mesa mesa : mesas) {
            adicionarBotaoMesa(mesa);
        }
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
                super.mouseClicked(e);
            }
        });
        jButton.setBackground(getCorBotao(mesa.getStatus()));
        return jButton;
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

    private void adicionarBotaoMesa(Mesa mesa) {
        gridConstraints.gridwidth = proximoIndiceColuna % 5; //Somente 5 colunas
        panelMesas.add(criarBotao(mesa), gridConstraints);
        proximoIndiceColuna++;
    }
}
