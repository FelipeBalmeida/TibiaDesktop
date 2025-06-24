package Controller;

import Model.Paladin;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PaladinController {

    private List<Paladin> paladins;
    private final String CAMINHO_ARQUIVO = "src/Personagens/paladins.dat";

    public PaladinController() {
        this.paladins = carregarPaladins();
    }

    private void salvarTodosPaladins() {
        File directory = new File("src/Personagens");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (FileOutputStream fileOut = new FileOutputStream(CAMINHO_ARQUIVO);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            objectOut.writeObject(paladins);

        } catch (IOException e) {
            System.out.println("Erro ao salvar todos os Paladins: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private List<Paladin> carregarPaladins() {
        File file = new File(CAMINHO_ARQUIVO);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (FileInputStream fileIn = new FileInputStream(CAMINHO_ARQUIVO);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            List<Paladin> loadedPaladins = (List<Paladin>) objectIn.readObject();
            return loadedPaladins;

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

    public void salvar(Paladin paladin) {
        this.paladins.add(paladin);
        salvarTodosPaladins();
    }

    public void excluir(String nome) {
        boolean removido = paladins.removeIf(paladin -> paladin.getNome().equals(nome));
        if (removido) {
            salvarTodosPaladins();
        }
    }

    public void alterar(String nome, int level, int skill) {
        boolean alterado = false;
        for (Paladin paladin : paladins) {
            if (paladin.getNome().equals(nome)) {
                paladin.setLevel(level);
                paladin.setSkill(skill);
                alterado = true;
                break;
            }
        }
        if (alterado) {
            salvarTodosPaladins();
        }
    }

    public List<Paladin> getTodosPaladins() {
        return new ArrayList<>(this.paladins);
    }

    public Paladin buscarPorNome(String nome) {
        for (Paladin paladin : paladins) {
            if (paladin.getNome().equals(nome)) {
                return paladin;
            }
        }
        return null;
    }
}