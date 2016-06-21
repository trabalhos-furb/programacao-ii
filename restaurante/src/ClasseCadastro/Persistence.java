/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasseCadastro;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author junio_000
 */
public class Persistence<T> {

    public Persistence() {
    }

    public void save(List<T> object, String nomeArquivo) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("src/Banco de Dados/" + nomeArquivo + ".data"))) {
            outputStream.writeObject(object);
        } catch (IOException ex) {
            throw new RuntimeException("Erro ao salvar arquivo", ex);
        }
    }

    public List<T> load(String nomeArquivo) {
        final String fileName = "src/Banco de Dados/" + nomeArquivo + ".data";
        if (Files.exists(Paths.get(fileName))) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
                return (List<T>) ois.readObject();
            } catch (IOException e) {
                throw new RuntimeException("Erro ao carregar arquivo", e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Erro ao converter classe", e);
            }
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        
    }
}
