package Controller;

import Model.Druid;
import DAO.DruidDAO;

import java.util.List;
import java.util.ArrayList;

public class DruidController {

    private DruidDAO druidDAO;

    public DruidController() {
        this.druidDAO = new DruidDAO();
    }

    public void salvar(Druid druid) {
        druidDAO.inserir(druid);
    }

    public void excluir(String nome) {
        druidDAO.excluir(nome);
    }

    public void alterar(String nome, int level, int magicLevel) {
        Druid druidParaAlterar = new Druid(nome, level, magicLevel);
        druidDAO.atualizar(druidParaAlterar);
    }

    public List<Druid> getTodosDruids() {
        return druidDAO.listarTodos();
    }

    public Druid buscarPorNome(String nome) {
        return druidDAO.buscarPorNome(nome);
    }
}