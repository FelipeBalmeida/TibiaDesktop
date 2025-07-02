package DAO;

import Conexao.AcessaBD;
import Model.Sorcerer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SorcererDAO {

    public void inserir(Sorcerer sorcerer) {
        String sql = "INSERT INTO sorcerers (nome, level, magic_level) VALUES (?, ?, ?)";
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = AcessaBD.getConnection();
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, sorcerer.getNome());
            stmt.setInt(2, sorcerer.getLevel());
            stmt.setInt(3, sorcerer.getMagicLevel());

            stmt.executeUpdate();
            System.out.println("Sorcerer inserido com sucesso no BD!");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir Sorcerer no BD: " + e.getMessage());
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

    public List<Sorcerer> listarTodos() {
        String sql = "SELECT id, nome, level, magic_level FROM sorcerers";
        List<Sorcerer> sorcerers = new ArrayList<>();
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
                int magicLevel = rs.getInt("magic_level");

                Sorcerer sorcerer = new Sorcerer(nome, level, magicLevel);
                sorcerers.add(sorcerer);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar Sorcerers do BD: " + e.getMessage());
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
        return sorcerers;
    }

    public Sorcerer buscarPorNome(String nomeBusca) {
        String sql = "SELECT id, nome, level, magic_level FROM sorcerers WHERE nome = ?";
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Sorcerer sorcerer = null;

        try {
            conexao = AcessaBD.getConnection();
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nomeBusca);

            rs = stmt.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                int level = rs.getInt("level");
                int magicLevel = rs.getInt("magic_level");
                sorcerer = new Sorcerer(nome, level, magicLevel);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar Sorcerer por nome no BD: " + e.getMessage());
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
        return sorcerer;
    }

    public void atualizar(Sorcerer sorcerer) {
        String sql = "UPDATE sorcerers SET level = ?, magic_level = ? WHERE nome = ?";
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = AcessaBD.getConnection();
            stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, sorcerer.getLevel());
            stmt.setInt(2, sorcerer.getMagicLevel());
            stmt.setString(3, sorcerer.getNome());

            stmt.executeUpdate();
            System.out.println("Sorcerer " + sorcerer.getNome() + " atualizado com sucesso no BD!");

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar Sorcerer no BD: " + e.getMessage());
            e.printStackTrace();
        } finally {
            AcessaBD.closeConnection(conexao);
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException e) { System.err.println("Erro ao fechar PreparedStatement: " + e.getMessage()); }
            }
        }
    }

    public void excluir(String nome) {
        String sql = "DELETE FROM sorcerers WHERE nome = ?";
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = AcessaBD.getConnection();
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, nome);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Sorcerer " + nome + " excluído com sucesso do BD!");
            } else {
                System.out.println("Sorcerer " + nome + " não encontrado no BD para exclusão.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao excluir Sorcerer do BD: " + e.getMessage());
            e.printStackTrace();
        } finally {
            AcessaBD.closeConnection(conexao);
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException e) { System.err.println("Erro ao fechar PreparedStatement: " + e.getMessage()); }
            }
        }
    }
}