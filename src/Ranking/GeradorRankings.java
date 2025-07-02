package Ranking;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import Conexao.AcessaBD;
import java.awt.Desktop; 
import java.io.File;   

public class GeradorRankings {


    private static final String PDF_OUTPUT_DIR = "src/pdf"; 

    // Métodos para Ranking Geral de Nível
    public static void visualizarRankingGeralNivel() {
        Connection conexao = null;
        InputStream relatorioStream = null;
        try {
            conexao = AcessaBD.getConnection();
            String caminhoJasperRecurso = "/Ranking/top_relatorio.jasper";

            relatorioStream = GeradorRankings.class.getResourceAsStream(caminhoJasperRecurso);
            if (relatorioStream == null) {
                throw new JRException("Recurso do relatório de Nível não encontrado: " + caminhoJasperRecurso);
            }

            Map<String, Object> parametros = new HashMap<>();

            JasperPrint jasperPrint = JasperFillManager.fillReport(relatorioStream, parametros, conexao);
            JasperViewer.viewReport(jasperPrint, false);
            System.out.println("Ranking Geral de Nível visualizado.");

        } catch (JRException e) {
            System.err.println("Erro ao visualizar o Ranking de Nível: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (relatorioStream != null) {
                try {
                    relatorioStream.close();
                } catch (IOException e) {
                    System.err.println("Erro ao fechar stream do relatório de Nível: " + e.getMessage());
                }
            }
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar a conexão do Ranking de Nível: " + e.getMessage());
                }
            }
        }
    }

    public static void gerarPDFRankingGeralNivel() {
        Connection conexao = null;
        InputStream relatorioStream = null;
        try {
            conexao = AcessaBD.getConnection();
            String caminhoJasperRecurso = "/Ranking/top_relatorio.jasper";

            relatorioStream = GeradorRankings.class.getResourceAsStream(caminhoJasperRecurso);
            if (relatorioStream == null) {
                throw new JRException("Recurso do relatório de Nível não encontrado: " + caminhoJasperRecurso);
            }

            Map<String, Object> parametros = new HashMap<>();

            JasperPrint jasperPrint = JasperFillManager.fillReport(relatorioStream, parametros, conexao);
            
            // Cria o diretório se não existir
            File outputDir = new File(PDF_OUTPUT_DIR);
            if (!outputDir.exists()) {
                outputDir.mkdirs(); // Cria o diretório e quaisquer pais necessários
            }

            // Define o caminho completo do arquivo PDF
            String nomeArquivoPDF = outputDir.getAbsolutePath() + File.separator + "RankingGeralNivel.pdf";
            
            // Exporta o relatório para PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivoPDF);
            System.out.println("Ranking Geral de Nível exportado para " + nomeArquivoPDF);


            if (Desktop.isDesktopSupported()) {
                File pdfFile = new File(nomeArquivoPDF);
                if (pdfFile.exists()) {
                    Desktop.getDesktop().open(pdfFile);
                    System.out.println("PDF " + nomeArquivoPDF + " aberto com sucesso!");
                } else {
                    System.err.println("Erro: O arquivo PDF " + nomeArquivoPDF + " não foi encontrado para ser aberto.");
                }
            } else {
                System.err.println("Desktop não é suportado no seu sistema operacional para abrir o PDF.");
            }

        } catch (JRException e) {
            System.err.println("Erro ao gerar PDF do Ranking de Nível: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Erro de I/O ao tentar abrir o PDF: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (relatorioStream != null) {
                try {
                    relatorioStream.close();
                } catch (IOException e) {
                    System.err.println("Erro ao fechar stream do relatório de Nível: " + e.getMessage());
                }
            }
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar a conexão do Ranking de Nível: " + e.getMessage());
                }
            }
        }
    }

    // Métodos para Ranking Geral de Skill
    public static void visualizarRankingGeralSkill() {
        Connection conexao = null;
        InputStream relatorioStream = null;
        try {
            conexao = AcessaBD.getConnection();
            String caminhoJasperRecurso = "/Ranking/skil_relatorio.jasper";

            relatorioStream = GeradorRankings.class.getResourceAsStream(caminhoJasperRecurso);
            if (relatorioStream == null) {
                throw new JRException("Recurso do relatório de Skill não encontrado: " + caminhoJasperRecurso);
            }

            Map<String, Object> parametros = new HashMap<>();

            JasperPrint jasperPrint = JasperFillManager.fillReport(relatorioStream, parametros, conexao);
            JasperViewer.viewReport(jasperPrint, false);
            System.out.println("Ranking Geral de Skill visualizado.");

        } catch (JRException e) {
            System.err.println("Erro ao visualizar o Ranking de Skill: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (relatorioStream != null) {
                try {
                    relatorioStream.close();
                } catch (IOException e) {
                    System.err.println("Erro ao fechar stream do relatório de Skill: " + e.getMessage());
                }
            }
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar a conexão do Ranking de Skill: " + e.getMessage());
                }
            }
        }
    }

    public static void gerarPDFRankingGeralSkill() {
        Connection conexao = null;
        InputStream relatorioStream = null;
        try {
            conexao = AcessaBD.getConnection();
            String caminhoJasperRecurso = "/Ranking/skil_relatorio.jasper";

            relatorioStream = GeradorRankings.class.getResourceAsStream(caminhoJasperRecurso);
            if (relatorioStream == null) {
                throw new JRException("Recurso do relatório de Skill não encontrado: " + caminhoJasperRecurso);
            }

            Map<String, Object> parametros = new HashMap<>();

            JasperPrint jasperPrint = JasperFillManager.fillReport(relatorioStream, parametros, conexao);
            
            // Cria o diretório se não existir
            File outputDir = new File(PDF_OUTPUT_DIR);
            if (!outputDir.exists()) {
                outputDir.mkdirs();
            }

            // Define o caminho completo do arquivo PDF
            String nomeArquivoPDF = outputDir.getAbsolutePath() + File.separator + "RankingGeralSkill.pdf";
            
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivoPDF);
            System.out.println("Ranking Geral de Skill exportado para " + nomeArquivoPDF);

            if (Desktop.isDesktopSupported()) {
                File pdfFile = new File(nomeArquivoPDF);
                if (pdfFile.exists()) {
                    Desktop.getDesktop().open(pdfFile);
                    System.out.println("PDF " + nomeArquivoPDF + " aberto com sucesso!");
                } else {
                    System.err.println("Erro: O arquivo PDF " + nomeArquivoPDF + " não foi encontrado para ser aberto.");
                }
            } else {
                System.err.println("Desktop não é suportado no seu sistema operacional para abrir o PDF.");
            }

        } catch (JRException e) {
            System.err.println("Erro ao gerar PDF do Ranking de Skill: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Erro de I/O ao tentar abrir o PDF: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (relatorioStream != null) {
                try {
                    relatorioStream.close();
                } catch (IOException e) {
                    System.err.println("Erro ao fechar stream do relatório de Skill: " + e.getMessage());
                }
            }
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar a conexão do Ranking de Skill: " + e.getMessage());
                }
            }
        }
    }

    // Métodos para Ranking Geral de Magic Level
    public static void visualizarRankingGeralML() {
        Connection conexao = null;
        InputStream relatorioStream = null;
        try {
            conexao = AcessaBD.getConnection();
            String caminhoJasperRecurso = "/Ranking/ml_relatorio.jasper";

            relatorioStream = GeradorRankings.class.getResourceAsStream(caminhoJasperRecurso);
            if (relatorioStream == null) {
                throw new JRException("Recurso do relatório de Magic Level não encontrado: " + caminhoJasperRecurso);
            }

            Map<String, Object> parametros = new HashMap<>();

            JasperPrint jasperPrint = JasperFillManager.fillReport(relatorioStream, parametros, conexao);
            JasperViewer.viewReport(jasperPrint, false);
            System.out.println("Ranking Geral de Magic Level visualizado.");

        } catch (JRException e) {
            System.err.println("Erro ao visualizar o Ranking de ML: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (relatorioStream != null) {
                try {
                    relatorioStream.close();
                } catch (IOException e) {
                    System.err.println("Erro ao fechar stream do relatório de ML: " + e.getMessage());
                }
            }
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar a conexão do Ranking de ML: " + e.getMessage());
                }
            }
        }
    }

    public static void gerarPDFRankingGeralML() {
        Connection conexao = null;
        InputStream relatorioStream = null;
        try {
            conexao = AcessaBD.getConnection();
            String caminhoJasperRecurso = "/Ranking/ml_relatorio.jasper";

            relatorioStream = GeradorRankings.class.getResourceAsStream(caminhoJasperRecurso);
            if (relatorioStream == null) {
                throw new JRException("Recurso do relatório de Magic Level não encontrado: " + caminhoJasperRecurso);
            }

            Map<String, Object> parametros = new HashMap<>();

            JasperPrint jasperPrint = JasperFillManager.fillReport(relatorioStream, parametros, conexao);
            
            // Cria o diretório se não existir
            File outputDir = new File(PDF_OUTPUT_DIR);
            if (!outputDir.exists()) {
                outputDir.mkdirs();
            }

            // Define o caminho completo do arquivo PDF
            String nomeArquivoPDF = outputDir.getAbsolutePath() + File.separator + "RankingGeralML.pdf";
            
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivoPDF);
            System.out.println("Ranking Geral de Magic Level exportado para " + nomeArquivoPDF);

            if (Desktop.isDesktopSupported()) {
                File pdfFile = new File(nomeArquivoPDF);
                if (pdfFile.exists()) {
                    Desktop.getDesktop().open(pdfFile);
                    System.out.println("PDF " + nomeArquivoPDF + " aberto com sucesso!");
                } else {
                    System.err.println("Erro: O arquivo PDF " + nomeArquivoPDF + " não foi encontrado para ser aberto.");
                }
            } else {
                System.err.println("Desktop não é suportado no seu sistema operacional para abrir o PDF.");
            }

        } catch (JRException e) {
            System.err.println("Erro ao gerar PDF do Ranking de ML: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Erro de I/O ao tentar abrir o PDF: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (relatorioStream != null) {
                try {
                    relatorioStream.close();
                } catch (IOException e) {
                    System.err.println("Erro ao fechar stream do relatório de ML: " + e.getMessage());
                }
            }
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar a conexão do Ranking de ML: " + e.getMessage());
                }
            }
        }
    }
}