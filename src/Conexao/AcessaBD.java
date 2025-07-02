package Conexao;

import java.io.File; // Importar File
import java.io.FileInputStream; // Importar FileInputStream
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

public class AcessaBD {

    private static Properties props = new Properties();

    static {

        try (InputStream input = AcessaBD.class.getClassLoader().getResourceAsStream("configuracaobd.properties")) {
            if (input == null) {
                File propertiesFile = new File("src/Conexao/configuracaobd.properties"); 
                if (!propertiesFile.exists()) {
                    throw new IOException("Arquivo configuracaobd.properties não encontrado. Caminhos tentados: ClassLoader e " + propertiesFile.getAbsolutePath());
                }
                try (InputStream fileInput = new FileInputStream(propertiesFile)) {
                    props.load(fileInput);
                    System.out.println("Arquivo de propriedades carregado via FileInputStream.");
                }
            } else {
                props.load(input);
                System.out.println("Arquivo de propriedades carregado via ClassLoader.");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar propriedades do banco de dados: " + ex.getMessage(), "Erro de Configuração", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            throw new RuntimeException("Falha ao carregar configuracaobd.properties", ex);
        }
    }

    private static final String URL = props.getProperty("jdbc.url");
    private static final String USUARIO = props.getProperty("jdbc.username");
    private static final String SENHA = props.getProperty("jdbc.password");

    public static Connection getConnection() {
        Connection conexao = null;
        try {
            Class.forName(props.getProperty("jdbc.driver"));
            System.out.println("Driver PostgreSQL carregado!");

            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver do banco de dados não encontrado. Verifique se o JAR do PostgreSQL foi adicionado ao projeto.", "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados. Verifique o URL, usuário, senha e se o PostgreSQL está em execução.\n" + e.getMessage(), "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return conexao;
    }

    public static void closeConnection(Connection conexao) {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
                System.out.println("Conexão com o banco de dados fechada.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão com o banco de dados: " + e.getMessage(), "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Iniciando teste de conexão...");
        Connection conexaoTeste = getConnection();
        if (conexaoTeste != null) {
            System.out.println("Teste de conexão com AcessaBD bem-sucedido!");
            AcessaBD.closeConnection(conexaoTeste);
        } else {
            System.out.println("Teste de conexão com AcessaBD falhou.");
        }
    }
}