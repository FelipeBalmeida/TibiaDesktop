package DAO;

import Conexao.AcessaBD;
import Model.Paladin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaladinDAO {

    public void inserir(Paladin paladin) {
        String sql = "INSERT INTO paladins (nome, level, skill) VALUES (?, ?, ?)";
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = AcessaBD.getConnection();
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, paladin.getNome());
            stmt.setInt(2, paladin.getLevel());
            stmt.setInt(3, paladin.getSkill());

            stmt.executeUpdate();
            System.out.println("Paladin inserido com sucesso no BD!");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir Paladin no BD: " + e.getMessage());
            e.printStackTrace();
        } finally {
            AcessaBD.closeConnection(conexao);
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar PreparedStatement: " + e.getMessage());
                }
            }
        }
    }

    public List<Paladin> listarTodos() {
        String sql = "SELECT id, nome, level, skill FROM paladins";
        List<Paladin> paladins = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = AcessaBD.getConnection();
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                int level = rs.getInt("level");
                int skill = rs.getInt("skill");

                Paladin paladin = new Paladin(nome, level, skill);
                paladins.add(paladin);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar Paladins do BD: " + e.getMessage());
            e.printStackTrace();
        } finally {
            AcessaBD.closeConnection(conexao);
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { System.err.println("Erro ao fechar ResultSet: " + e.getMessage()); }
            }
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException e) { System.err.println("Erro ao fechar PreparedStatement: " + e.getMessage()); }
            }
        }
        return paladins;
    }

    public Paladin buscarPorNome(String nomeBusca) {
        String sql = "SELECT id, nome, level, skill FROM paladins WHERE nome = ?";
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Paladin paladin = null;

        try {
            conexao = AcessaBD.getConnection();
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nomeBusca);

            rs = stmt.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                int level = rs.getInt("level");
                int skill = rs.getInt("skill");
                paladin = new Paladin(nome, level, skill);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar Paladin por nome no BD: " + e.getMessage());
            e.printStackTrace();
        } finally {
            AcessaBD.closeConnection(conexao);
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { System.err.println("Erro ao fechar ResultSet: " + e.getMessage()); }
            }
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException e) { System.err.println("Erro ao fechar PreparedStatement: " + e.getMessage()); }
            }
        }
        return paladin;
    }

    public void atualizar(Paladin paladin) {
        String sql = "UPDATE paladins SET level = ?, skill = ? WHERE nome = ?";
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = AcessaBD.getConnection();
            stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, paladin.getLevel());
            stmt.setInt(2, paladin.getSkill());
            stmt.setString(3, paladin.getNome());

            stmt.executeUpdate();
            System.out.println("Paladin " + paladin.getNome() + " atualizado com sucesso no BD!");

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar Paladin no BD: " + e.getMessage());
            e.printStackTrace();
        } finally {
            AcessaBD.closeConnection(conexao);
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException e) { System.err.println("Erro ao fechar PreparedStatement: " + e.getMessage()); }
            }
        }
    }

    public void excluir(String nome) {
        String sql = "DELETE FROM paladins WHERE nome = ?";
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = AcessaBD.getConnection();
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, nome);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Paladin " + nome + " excluído com sucesso do BD!");
            } else {
                System.out.println("Paladin " + nome + " não encontrado no BD para exclusão.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao excluir Paladin do BD: " + e.getMessage());
            e.printStackTrace();
        } finally {
            AcessaBD.closeConnection(conexao);
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException e) { System.err.println("Erro ao fechar PreparedStatement: " + e.getMessage()); }
            }
        }
    }
}