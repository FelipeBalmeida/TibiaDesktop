package Controller;

import Model.Paladin;
import DAO.PaladinDAO;

import java.util.List;
import java.util.ArrayList; // Mantido, embora getTodosPaladins agora venha do DAO

public class PaladinController {

    private PaladinDAO paladinDAO;

    public PaladinController() {
        this.paladinDAO = new PaladinDAO();
    }

    public void salvar(Paladin paladin) {
        paladinDAO.inserir(paladin);
    }

    public void excluir(String nome) {
        paladinDAO.excluir(nome);
    }

    public void alterar(String nome, int level, int skill) {
        Paladin paladinParaAlterar = new Paladin(nome, level, skill);
        paladinDAO.atualizar(paladinParaAlterar);
    }

    public List<Paladin> getTodosPaladins() {
        return paladinDAO.listarTodos();
    }

    public Paladin buscarPorNome(String nome) {
        return paladinDAO.buscarPorNome(nome);
    }
}