package Controller;

import Model.Sorcerer;
import DAO.SorcererDAO;

import java.util.List;
import java.util.ArrayList;

public class SorcererController {

    private SorcererDAO sorcererDAO;

    public SorcererController() {
        this.sorcererDAO = new SorcererDAO();
    }

    public void salvar(Sorcerer sorcerer) {
        sorcererDAO.inserir(sorcerer);
    }

    public void excluir(String nome) {
        sorcererDAO.excluir(nome);
    }

    public void alterar(String nome, int level, int magicLevel) {
        Sorcerer sorcererParaAlterar = new Sorcerer(nome, level, magicLevel);
        sorcererDAO.atualizar(sorcererParaAlterar);
    }

    public List<Sorcerer> getTodosSorcerers() {
        return sorcererDAO.listarTodos();
    }

    public Sorcerer buscarPorNome(String nome) {
        return sorcererDAO.buscarPorNome(nome);
    }
}