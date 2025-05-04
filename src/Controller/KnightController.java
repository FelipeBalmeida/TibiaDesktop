/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Knight;

import java.io.*;
import java.util.*;

public class KnightController {

    private List<Knight> knights = new ArrayList<>();

    // Método para salvar Knight
    public void salvar(Knight knight) {
        try {
            // Caminho correto para dentro da pasta src/Personagens
            File directory = new File("src/Personagens");
            if (!directory.exists()) {
                directory.mkdirs(); // Cria a pasta Personagens dentro de src, caso não exista
            }

            // Agora salva o arquivo knights.txt dentro de src/Personagens
            PrintWriter writer = new PrintWriter(new FileWriter("src/Personagens/knights.txt", true));
            writer.println(knight.getNome() + "," + knight.getLevel() + "," + knight.getSkill());
            knights.add(knight);
            writer.close();
            System.out.println("Knight salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar Knight: " + e.getMessage());
        }
    }

    // Método para excluir Knight
    public void excluir(String nome) {
        for (Knight knight : knights) {
            if (knight.getNome().equals(nome)) {
                knights.remove(knight);
                System.out.println("Knight " + nome + " excluído com sucesso!");
                return;
            }
        }
        System.out.println("Knight não encontrado.");
    }

    // Método para alterar dados de Knight
    public void alterar(String nome, int level, int skill) {
        for (Knight knight : knights) {
            if (knight.getNome().equals(nome)) {
                knight.setLevel(level);
                knight.setSkill(skill);
                System.out.println("Dados do Knight " + nome + " alterados com sucesso!");
                return;
            }
        }
        System.out.println("Knight não encontrado.");
    }
}
