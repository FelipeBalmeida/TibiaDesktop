package DAO;

import Conexao.AcessaBD;
import Model.Druid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DruidDAO {

    public void inserir(Druid druid) {
        String sql = "INSERT INTO druids (nome, level, magic_level) VALUES (?, ?, ?)";
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = AcessaBD.getConnection();
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, druid.getNome());
            stmt.setInt(2, druid.getLevel());
            stmt.setInt(3, druid.getMagicLevel());

            stmt.executeUpdate();
            System.out.println("Druid inserido com sucesso no BD!");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir Druid no BD: " + e.getMessage());
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

    public List<Druid> listarTodos() {
        String sql = "SELECT id, nome, level, magic_level FROM druids";
        List<Druid> druids = new ArrayList<>();
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

                Druid druid = new Druid(nome, level, magicLevel);
                druids.add(druid);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar Druids do BD: " + e.getMessage());
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
        return druids;
    }

    public Druid buscarPorNome(String nomeBusca) {
        String sql = "SELECT id, nome, level, magic_level FROM druids WHERE nome = ?";
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Druid druid = null;

        try {
            conexao = AcessaBD.getConnection();
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nomeBusca);

            rs = stmt.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                int level = rs.getInt("level");
                int magicLevel = rs.getInt("magic_level");
                druid = new Druid(nome, level, magicLevel);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar Druid por nome no BD: " + e.getMessage());
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
        return druid;
    }

    public void atualizar(Druid druid) {
        String sql = "UPDATE druids SET level = ?, magic_level = ? WHERE nome = ?";
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = AcessaBD.getConnection();
            stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, druid.getLevel());
            stmt.setInt(2, druid.getMagicLevel());
            stmt.setString(3, druid.getNome());

            stmt.executeUpdate();
            System.out.println("Druid " + druid.getNome() + " atualizado com sucesso no BD!");

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar Druid no BD: " + e.getMessage());
            e.printStackTrace();
        } finally {
            AcessaBD.closeConnection(conexao);
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException e) { System.err.println("Erro ao fechar PreparedStatement: " + e.getMessage()); }
            }
        }
    }

    public void excluir(String nome) {
        String sql = "DELETE FROM druids WHERE nome = ?";
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = AcessaBD.getConnection();
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, nome);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Druid " + nome + " excluído com sucesso do BD!");
            } else {
                System.out.println("Druid " + nome + " não encontrado no BD para exclusão.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao excluir Druid do BD: " + e.getMessage());
            e.printStackTrace();
        } finally {
            AcessaBD.closeConnection(conexao);
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException e) { System.err.println("Erro ao fechar PreparedStatement: " + e.getMessage()); }
            }
        }
    }
}