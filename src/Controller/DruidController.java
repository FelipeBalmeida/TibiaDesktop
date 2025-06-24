package Controller;

import Model.Druid;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DruidController {

    private List<Druid> druids;
    private final String CAMINHO_ARQUIVO = "src/Personagens/druids.dat";

    public DruidController() {
        this.druids = carregarDruids();
    }

    private void salvarTodosDruids() {
        File directory = new File("src/Personagens");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (FileOutputStream fileOut = new FileOutputStream(CAMINHO_ARQUIVO);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            objectOut.writeObject(druids);

        } catch (IOException e) {
            System.out.println("Erro ao salvar todos os Druids: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private List<Druid> carregarDruids() {
        File file = new File(CAMINHO_ARQUIVO);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (FileInputStream fileIn = new FileInputStream(CAMINHO_ARQUIVO);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) { // AQUI ESTÁ A CORREÇÃO

            List<Druid> loadedDruids = (List<Druid>) objectIn.readObject();
            return loadedDruids;

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

    public void salvar(Druid druid) {
        this.druids.add(druid);
        salvarTodosDruids();
    }

    public void excluir(String nome) {
        boolean removido = druids.removeIf(druid -> druid.getNome().equals(nome));
        if (removido) {
            salvarTodosDruids();
        }
    }

    public void alterar(String nome, int level, int magicLevel) {
        boolean alterado = false;
        for (Druid druid : druids) {
            if (druid.getNome().equals(nome)) {
                druid.setLevel(level);
                druid.setMagicLevel(magicLevel);
                alterado = true;
                break;
            }
        }
        if (alterado) {
            salvarTodosDruids();
        }
    }

    public List<Druid> getTodosDruids() {
        return new ArrayList<>(this.druids);
    }

    public Druid buscarPorNome(String nome) {
        for (Druid druid : druids) {
            if (druid.getNome().equals(nome)) {
                return druid;
            }
        }
        return null;
    }
}