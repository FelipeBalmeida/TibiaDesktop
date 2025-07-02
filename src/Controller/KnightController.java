package Controller;

import Model.Knight;
import DAO.KnightDAO;

import java.util.List;
import java.util.ArrayList;

public class KnightController {

    private KnightDAO knightDAO;

    public KnightController() {
        this.knightDAO = new KnightDAO();
    }

    public void salvar(Knight knight) {
        knightDAO.inserir(knight);
    }

    public void excluir(String nome) {
        knightDAO.excluir(nome);
    }

    public void alterar(String nome, int level, int skill) {
        Knight knightParaAlterar = new Knight(nome, level, skill);
        knightDAO.atualizar(knightParaAlterar);
    }

    public List<Knight> getTodosKnights() {
        return knightDAO.listarTodos();
    }

    public Knight buscarPorNome(String nome) {
        return knightDAO.buscarPorNome(nome);
    }
}