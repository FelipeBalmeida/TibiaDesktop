package Controller;

import Model.Sorcerer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SorcererController {

    private List<Sorcerer> sorcerers;
    private final String CAMINHO_ARQUIVO = "src/Personagens/sorcerers.dat";

    public SorcererController() {
        this.sorcerers = carregarSorcerers();
    }

    private void salvarTodosSorcerers() {
        File directory = new File("src/Personagens");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (FileOutputStream fileOut = new FileOutputStream(CAMINHO_ARQUIVO);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            objectOut.writeObject(sorcerers);

        } catch (IOException e) {
            System.out.println("Erro ao salvar todos os Sorcerers: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private List<Sorcerer> carregarSorcerers() {
        File file = new File(CAMINHO_ARQUIVO);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (FileInputStream fileIn = new FileInputStream(CAMINHO_ARQUIVO);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            List<Sorcerer> loadedSorcerers = (List<Sorcerer>) objectIn.readObject();
            return loadedSorcerers;

        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void salvar(Sorcerer sorcerer) {
        this.sorcerers.add(sorcerer);
        salvarTodosSorcerers();
    }

    public void excluir(String nome) {
        boolean removido = sorcerers.removeIf(sorcerer -> sorcerer.getNome().equals(nome));
        if (removido) {
            salvarTodosSorcerers();
        }
    }

    public void alterar(String nome, int level, int magicLevel) {
        boolean alterado = false;
        for (Sorcerer sorcerer : sorcerers) {
            if (sorcerer.getNome().equals(nome)) {
                sorcerer.setLevel(level);
                sorcerer.setMagicLevel(magicLevel);
                alterado = true;
                break;
            }
        }
        if (alterado) {
            salvarTodosSorcerers();
        }
    }

    public List<Sorcerer> getTodosSorcerers() {
        return new ArrayList<>(this.sorcerers);
    }

    public Sorcerer buscarPorNome(String nome) {
        for (Sorcerer sorcerer : sorcerers) {
            if (sorcerer.getNome().equals(nome)) {
                return sorcerer;
            }
        }
        return null;
    }
}