package Controller;

import ClasseCadastro.Produto;
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

public class ControllerProduto {

    Path verificaSeExiste = Paths.get("./src/Banco de Dados/Produtos.data");
    private HashMap<Integer, Produto> listaProdutos;

    public ControllerProduto() {
        listaProdutos = new HashMap<>();
        this.carregaListaProduto();
    }

    
    
    public Produto pesquisarProduto(int codigo) {
        Produto produto = listaProdutos.get(codigo);
        if (listaProdutos.get(codigo) == null) {
            
        }
        return produto;
    }

    public boolean verificaProduto(int codigo){
        if(listaProdutos.containsKey(codigo)){
            return true;
        }
        JOptionPane.showMessageDialog(null, "Produto não foi encontrado!");
        return false;
            }
    
    public boolean listaProdutoVazia() {
        if (listaProdutos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado!!");
            return false;
        }
        return true;
    }

    public List listatodosProdutos() {
        List<Produto> lista = new ArrayList<>(listaProdutos.values());
        return lista;
    }

    public void removeProduto(int codigo) {
        listaProdutos.remove(codigo);
        this.salvarProduto("REMOVE");
    }

    public void gravarProduto(int codigo, String descricao, float valor) {

        if (listaProdutos.containsKey(codigo)) {
            if (JOptionPane.showConfirmDialog(null, "Deseja realmente alterar os dados?", "Atenção", JOptionPane.YES_NO_OPTION) == 0) {
                listaProdutos.get(codigo).setCodigo(codigo);
                listaProdutos.get(codigo).setDescricao(descricao);
                listaProdutos.get(codigo).setValor(valor);
                this.salvarProduto("SALVAR");
            }

        } else {

            Produto produto = new Produto(codigo, descricao, valor);
            listaProdutos.put(codigo, produto);
            this.salvarProduto("SALVAR");
        }
    }

    public void salvarProduto(String opcaoMensagem) {
        try {

            FileOutputStream fout = new FileOutputStream(verificaSeExiste.toString());
            ObjectOutputStream object = new ObjectOutputStream(fout);
            object.writeObject(listaProdutos);

            object.close();

            if (opcaoMensagem.equals("SALVAR")) {
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Produto removido!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void carregaListaProduto() {

        if (Files.exists(verificaSeExiste)) {

            try {

                FileInputStream fin = new FileInputStream(verificaSeExiste.toString());
                ObjectInputStream objectinput = new ObjectInputStream(fin);

                listaProdutos = (HashMap) objectinput.readObject();

                objectinput.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
