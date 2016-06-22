package Controller;

import modelo.produto.Produto;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.produto.FabricaServicoProduto;
import modelo.produto.ServicoProduto;

public class ControllerProduto {

    Path verificaSeExiste = Paths.get("./src/Banco de Dados/Produtos.data");
    private final ServicoProduto servicoProduto;

    public ControllerProduto() {
        this.servicoProduto = FabricaServicoProduto.getServicoProduto();
    }

    public void removeProduto(int codigo) {
        servicoProduto.removerProduto(codigo);
    }
    
    public boolean existeProduto(int codigo){
        return servicoProduto.getProduto(codigo) != null;
    }

    public void gravarProduto(int codigo, String descricao, float valor) {

        if (servicoProduto.existeProduto(codigo)) {
            if (JOptionPane.showConfirmDialog(null, "Deseja realmente alterar os dados?", "Atenção", JOptionPane.YES_NO_OPTION) == 0) {
                Produto produto = servicoProduto.getProduto(codigo);
                produto.setCodigo(codigo);
                produto.setDescricao(descricao);
                produto.setValor(valor);
                servicoProduto.persistir();
            }
        } else {
            servicoProduto.addProduto(codigo, descricao, valor);
            servicoProduto.persistir();
        }
    }
    
    public List<Produto> pesquisar(ModoPesquisaProduto modoPesquisa) {
        return null;
    }
}
