package Controller;

import Model.Druid;

import java.io.*;
import java.util.*;

public class DruidController {

    private List<Druid> druids = new ArrayList<>();

    // Método para salvar Druid
    public void salvar(Druid druid) {
        try {
            // Caminho correto para dentro da pasta src/Personagens
            File directory = new File("src/Personagens");
            if (!directory.exists()) {
                directory.mkdirs(); // Cria a pasta Personagens dentro de src, caso não exista
            }

            // Agora salva o arquivo druids.txt dentro de src/Personagens
            PrintWriter writer = new PrintWriter(new FileWriter("src/Personagens/druids.txt", true));
            writer.println(druid.getNome() + "," + druid.getLevel() + "," + druid.getMagicLevel());
            druids.add(druid);
            writer.close();
            System.out.println("Druid salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar Druid: " + e.getMessage());
        }
    }

    // Método para excluir Druid
    public void excluir(String nome) {
        for (Druid druid : druids) {
            if (druid.getNome().equals(nome)) {
                druids.remove(druid);
                System.out.println("Druid " + nome + " excluído com sucesso!");
                return;
            }
        }
        System.out.println("Druid não encontrado.");
    }

    // Método para alterar dados de Druid
    public void alterar(String nome, int level, int magicLevel) {
        for (Druid druid : druids) {
            if (druid.getNome().equals(nome)) {
                druid.setLevel(level);
                druid.setMagicLevel(magicLevel);
                System.out.println("Dados do Druid " + nome + " alterados com sucesso!");
                return;
            }
        }
        System.out.println("Druid não encontrado.");
    }
}
