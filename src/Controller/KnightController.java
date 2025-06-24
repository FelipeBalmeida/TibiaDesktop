/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Knight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class KnightController {

    private List<Knight> knights;
    private final String CAMINHO_ARQUIVO = "src/Personagens/knights.dat";

    public KnightController() {
        this.knights = carregarKnights();
    }

    private void salvarTodosKnights() {
        File directory = new File("src/Personagens");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (FileOutputStream fileOut = new FileOutputStream(CAMINHO_ARQUIVO);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            objectOut.writeObject(knights);

        } catch (IOException e) {
            System.out.println("Erro ao salvar todos os Knights: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private List<Knight> carregarKnights() {
        File file = new File(CAMINHO_ARQUIVO);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (FileInputStream fileIn = new FileInputStream(CAMINHO_ARQUIVO);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            List<Knight> loadedKnights = (List<Knight>) objectIn.readObject();
            return loadedKnights;

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

    public void salvar(Knight knight) {
        this.knights.add(knight);
        salvarTodosKnights();
    }

    public void excluir(String nome) {
        boolean removido = knights.removeIf(knight -> knight.getNome().equals(nome));
        if (removido) {
            salvarTodosKnights();
        }
    }

    public void alterar(String nome, int level, int skill) {
        boolean alterado = false;
        for (Knight knight : knights) {
            if (knight.getNome().equals(nome)) {
                knight.setLevel(level);
                knight.setSkill(skill);
                alterado = true;
                break;
            }
        }
        if (alterado) {
            salvarTodosKnights();
        }
    }

    public List<Knight> getTodosKnights() {
        return new ArrayList<>(this.knights);
    }

    public Knight buscarPorNome(String nome) {
        for (Knight knight : knights) {
            if (knight.getNome().equals(nome)) {
                return knight;
            }
        }
        return null;
    }
}