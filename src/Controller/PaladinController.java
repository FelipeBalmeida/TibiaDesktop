package Controller;

import Model.Paladin;
import java.io.*;
import java.util.*;

public class PaladinController {

    private List<Paladin> paladins = new ArrayList<>();

    // Método para salvar Paladin
    public void salvar(Paladin paladin) {
        try {
            // Caminho correto para dentro da pasta src/Personagens
            File directory = new File("src/Personagens");
            if (!directory.exists()) {
                directory.mkdirs(); // Cria a pasta Personagens dentro de src, caso não exista
            }

            // Agora salva o arquivo paladins.txt dentro de src/Personagens
            PrintWriter writer = new PrintWriter(new FileWriter("src/Personagens/paladins.txt", true));
            writer.println(paladin.getNome() + "," + paladin.getLevel() + "," + paladin.getSkill());
            paladins.add(paladin);
            writer.close();
            System.out.println("Paladin salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar Paladin: " + e.getMessage());
        }
    }

    // Método para excluir Paladin
    public void excluir(String nome) {
        for (Paladin paladin : paladins) {
            if (paladin.getNome().equals(nome)) {
                paladins.remove(paladin);
                System.out.println("Paladin " + nome + " excluído com sucesso!");
                return;
            }
        }
        System.out.println("Paladin não encontrado.");
    }

    // Método para alterar dados de Paladin
    public void alterar(String nome, int level, int skill) {
        for (Paladin paladin : paladins) {
            if (paladin.getNome().equals(nome)) {
                paladin.setLevel(level);
                paladin.setSkill(skill);
                System.out.println("Dados do Paladin " + nome + " alterados com sucesso!");
                return;
            }
        }
        System.out.println("Paladin não encontrado.");
    }
}
