/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author felip
 */
public class Druid {
    private String nome;
    private int level;
    private int magicLevel;

    public Druid(String nome, int level, int magicLevel) {
        this.nome = nome;
        this.level = level;
        this.magicLevel = magicLevel;
    }


    public void exibirStatus() {
        System.out.println("Druid: " + nome);
        System.out.println("Level: " + level);
        System.out.println("Magic Level: " + magicLevel);
    }

    public void salvarDados() {
        System.out.println("Salvando dados de Druid...");
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public int getLevel() {
        return level;
    }

    public int getMagicLevel() {
        return magicLevel;
    }
      // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setMagicLevel(int magicLevel) {
        this.magicLevel = magicLevel;
    } 
    
}