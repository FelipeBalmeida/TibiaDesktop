package Controller;

import Model.Sorcerer;
import java.io.*;
import java.util.*;

public class SorcererController {

    private List<Sorcerer> sorcerers = new ArrayList<>();

    // Método para salvar Sorcerer
    public void salvar(Sorcerer sorcerer) {
        try {
            // Caminho correto para dentro da pasta src/Personagens
            File directory = new File("src/Personagens");
            if (!directory.exists()) {
                directory.mkdirs(); // Cria a pasta Personagens dentro de src, caso não exista
            }

            // Agora salva o arquivo sorcerers.txt dentro de src/Personagens
            PrintWriter writer = new PrintWriter(new FileWriter("src/Personagens/sorcerers.txt", true));
            writer.println(sorcerer.getNome() + "," + sorcerer.getLevel() + "," + sorcerer.getMagicLevel());
            sorcerers.add(sorcerer);
            writer.close();
            System.out.println("Sorcerer salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar Sorcerer: " + e.getMessage());
        }
    }

    // Método para excluir Sorcerer
    public void excluir(String nome) {
        for (Sorcerer sorcerer : sorcerers) {
            if (sorcerer.getNome().equals(nome)) {
                sorcerers.remove(sorcerer);
                System.out.println("Sorcerer " + nome + " excluído com sucesso!");
                return;
            }
        }
        System.out.println("Sorcerer não encontrado.");
    }

    // Método para alterar dados de Sorcerer
    public void alterar(String nome, int level, int magicLevel) {
        for (Sorcerer sorcerer : sorcerers) {
            if (sorcerer.getNome().equals(nome)) {
                sorcerer.setLevel(level);
                sorcerer.setMagicLevel(magicLevel);
                System.out.println("Dados do Sorcerer " + nome + " alterados com sucesso!");
                return;
            }
        }
        System.out.println("Sorcerer não encontrado.");
    }
}
