package DAO;

import Conexao.AcessaBD;
import Model.Knight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KnightDAO {

    public void inserir(Knight knight) {
        String sql = "INSERT INTO knights (nome, level, skill) VALUES (?, ?, ?)";
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = AcessaBD.getConnection();
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, knight.getNome());
            stmt.setInt(2, knight.getLevel());
            stmt.setInt(3, knight.getSkill());

            stmt.executeUpdate();
            System.out.println("Knight inserido com sucesso no BD!");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir Knight no BD: " + e.getMessage());
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

    public List<Knight> listarTodos() {
        String sql = "SELECT id, nome, level, skill FROM knights";
        List<Knight> knights = new ArrayList<>();
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

                Knight knight = new Knight(nome, level, skill);
                knights.add(knight);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar Knights do BD: " + e.getMessage());
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
        return knights;
    }

    public Knight buscarPorNome(String nomeBusca) {
        String sql = "SELECT id, nome, level, skill FROM knights WHERE nome = ?";
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Knight knight = null;

        try {
            conexao = AcessaBD.getConnection();
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nomeBusca);

            rs = stmt.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                int level = rs.getInt("level");
                int skill = rs.getInt("skill");
                knight = new Knight(nome, level, skill);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar Knight por nome no BD: " + e.getMessage());
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
        return knight;
    }

    public void atualizar(Knight knight) {
        String sql = "UPDATE knights SET level = ?, skill = ? WHERE nome = ?";
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = AcessaBD.getConnection();
            stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, knight.getLevel());
            stmt.setInt(2, knight.getSkill());
            stmt.setString(3, knight.getNome());

            stmt.executeUpdate();
            System.out.println("Knight " + knight.getNome() + " atualizado com sucesso no BD!");

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar Knight no BD: " + e.getMessage());
            e.printStackTrace();
        } finally {
            AcessaBD.closeConnection(conexao);
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException e) { System.err.println("Erro ao fechar PreparedStatement: " + e.getMessage()); }
            }
        }
    }

    public void excluir(String nome) {
        String sql = "DELETE FROM knights WHERE nome = ?";
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = AcessaBD.getConnection();
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, nome);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Knight " + nome + " excluído com sucesso do BD!");
            } else {
                System.out.println("Knight " + nome + " não encontrado no BD para exclusão.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao excluir Knight do BD: " + e.getMessage());
            e.printStackTrace();
        } finally {
            AcessaBD.closeConnection(conexao);
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException e) { System.err.println("Erro ao fechar PreparedStatement: " + e.getMessage()); }
            }
        }
    }
}