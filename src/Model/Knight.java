/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author felip
 */
public class Knight implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private int level;
    private int skill;

    public Knight(String nome, int level, int skill) {
        this.nome = nome;
        this.level = level;
        this.skill = skill;
    }

    public void exibirStatus() {
        System.out.println("Knight: " + nome);
        System.out.println("Level: " + level);
        System.out.println("Skill: " + skill);
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public int getLevel() {
        return level;
    }

    public int getSkill() {
        return skill;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }
}