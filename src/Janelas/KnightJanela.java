/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Janelas;

import Controller.KnightController;
import Model.Knight;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.Image;

public class KnightJanela extends javax.swing.JFrame {

    private KnightController controller = new KnightController();
    private List<Knight> knightsList; // A lista será inicializada e preenchida pelo controller
    private int currentIndex = 0;
    private JLabel backgroundLabel;

    /**
     * Creates new form KnightJanela
     */
    public KnightJanela() {
        initComponents();
        carregarKnights(); // Carregar os knights ao iniciar a janela
        exibirKnight(); // Exibir o primeiro Knight
        setLocationRelativeTo(null);

        ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/imagens/1.png"));
        Image img = backgroundImage.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        backgroundLabel = new JLabel(new ImageIcon(img));

        backgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight());

        getLayeredPane().setLayout(null);
        getLayeredPane().add(backgroundLabel, new Integer(Integer.MIN_VALUE));

        ((JPanel) this.getContentPane()).setOpaque(false);

        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void carregarKnights() {
        this.knightsList = controller.getTodosKnights(); // Obtém a lista do Controller

        if (knightsList.isEmpty()) {
            currentIndex = 0;
        } else if (currentIndex >= knightsList.size()) {
            currentIndex = knightsList.size() - 1;
        }
    }

    private void exibirKnight() {
        if (!knightsList.isEmpty() && currentIndex >= 0 && currentIndex < knightsList.size()) {
            Knight currentKnight = knightsList.get(currentIndex);
            // Preencher os JTextFields com os dados do Knight atual
            jTextFieldNomeKnight.setText(currentKnight.getNome()); // Assumindo jTextFieldNomeKnight
            jTextFieldLevelKnight.setText(String.valueOf(currentKnight.getLevel())); // Assumindo jTextFieldLevelKnight
            jTextFieldSkillKnight.setText(String.valueOf(currentKnight.getSkill())); // Assumindo jTextFieldSkillKnight

            jLabelKnightSalvos.setText("Nome: " + currentKnight.getNome()
                    + " | Level: " + currentKnight.getLevel()
                    + " | Skill: " + currentKnight.getSkill());
        } else {
            // Limpa os campos se não houver Knight para exibir
            jTextFieldNomeKnight.setText("");
            jTextFieldLevelKnight.setText("");
            jTextFieldSkillKnight.setText("");
            jLabelKnightSalvos.setText("Nenhum Knight salvo.");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButtonSalvarKnight = new javax.swing.JButton();
        jButtonExcluirKnight = new javax.swing.JButton();
        jButtonAlterarKnight = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNomeKnight = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldLevelKnight = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextFieldSkillKnight = new javax.swing.JTextPane();
        jLabelKnightSalvos = new javax.swing.JLabel();
        jButtonPassarKnight = new javax.swing.JButton();
        jButtonPesquisarKnight = new javax.swing.JButton();

        jButton3.setText("jButton3");

        jButton4.setText("jButton4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonSalvarKnight.setText("Salvar");
        jButtonSalvarKnight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSalvarKnightMouseClicked(evt);
            }
        });
        jButtonSalvarKnight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarKnightActionPerformed(evt);
            }
        });

        jButtonExcluirKnight.setText("Excluir");
        jButtonExcluirKnight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonExcluirKnightMouseClicked(evt);
            }
        });

        jButtonAlterarKnight.setText("Alterar");
        jButtonAlterarKnight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAlterarKnightMouseClicked(evt);
            }
        });
        jButtonAlterarKnight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarKnightActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(51, 255, 51));
        jLabel1.setText("Nome");

        jTextFieldNomeKnight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeKnightActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(102, 255, 102));
        jLabel2.setText("Level");

        jLabel3.setForeground(new java.awt.Color(51, 255, 51));
        jLabel3.setText("Skill");

        jTextFieldLevelKnight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLevelKnightActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jTextFieldSkillKnight);

        jLabelKnightSalvos.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabelKnightSalvos.setForeground(new java.awt.Color(51, 255, 51));

        jButtonPassarKnight.setText("Atualizar ou >>>");
        jButtonPassarKnight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonPassarKnightMouseClicked(evt);
            }
        });
        jButtonPassarKnight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPassarKnightActionPerformed(evt);
            }
        });

        jButtonPesquisarKnight.setText("Pesquisar");
        jButtonPesquisarKnight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonPesquisarKnightMouseClicked(evt);
            }
        });
        jButtonPesquisarKnight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarKnightActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelKnightSalvos, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldNomeKnight, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                    .addComponent(jTextFieldLevelKnight)
                                    .addComponent(jScrollPane1))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPesquisarKnight)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonSalvarKnight)
                        .addGap(74, 74, 74)
                        .addComponent(jButtonExcluirKnight)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonPassarKnight)
                            .addComponent(jButtonAlterarKnight))
                        .addGap(29, 29, 29))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNomeKnight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisarKnight))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldLevelKnight, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonPassarKnight)
                    .addComponent(jLabelKnightSalvos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvarKnight)
                    .addComponent(jButtonExcluirKnight)
                    .addComponent(jButtonAlterarKnight))
                .addGap(65, 65, 65))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldLevelKnightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLevelKnightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLevelKnightActionPerformed

    private void jButtonAlterarKnightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarKnightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAlterarKnightActionPerformed

    private void jButtonSalvarKnightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSalvarKnightMouseClicked
// Pega os dados dos campos e adiciona tratamento de erro
        String nome = jTextFieldNomeKnight.getText();

        int level = 0;
        try {
            level = Integer.parseInt(jTextFieldLevelKnight.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um número válido para o Level.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
            return; // Sai do método se houver erro
        }

        int skill = 0;
        try {
            skill = Integer.parseInt(jTextFieldSkillKnight.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um número válido para o Skill.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
            return; // Sai do método se houver erro
        }

        // Cria o objeto Knight
        Knight knight = new Knight(nome, level, skill);

        // Salva usando o controller
        controller.salvar(knight);

        // Mensagem de sucesso
        JOptionPane.showMessageDialog(this, "Knight salvo com sucesso!");

        // Recarrega a lista para refletir a adição e exibe o novo Knight
        carregarKnights();
        currentIndex = knightsList.size() - 1; // Vai para o último adicionado
        exibirKnight();
    }//GEN-LAST:event_jButtonSalvarKnightMouseClicked

    private void jButtonSalvarKnightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarKnightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSalvarKnightActionPerformed

    private void jButtonPassarKnightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPassarKnightMouseClicked
        if (!knightsList.isEmpty()) {
            currentIndex = (currentIndex + 1) % knightsList.size();
            exibirKnight();
        }
    }//GEN-LAST:event_jButtonPassarKnightMouseClicked

    private void jButtonPassarKnightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPassarKnightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonPassarKnightActionPerformed

    private void jButtonExcluirKnightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonExcluirKnightMouseClicked
        if (!knightsList.isEmpty() && currentIndex >= 0 && currentIndex < knightsList.size()) {
            String nomeParaExcluir = knightsList.get(currentIndex).getNome();
            int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir o Knight " + nomeParaExcluir + "?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                controller.excluir(nomeParaExcluir);
                JOptionPane.showMessageDialog(this, "Knight " + nomeParaExcluir + " excluído com sucesso!");
                carregarKnights(); // Recarrega a lista para refletir a exclusão
                if (!knightsList.isEmpty()) {
                    if (currentIndex >= knightsList.size()) {
                        currentIndex = knightsList.size() - 1;
                    }
                    exibirKnight();
                } else {
                    exibirKnight(); // Exibe "Nenhum Knight salvo."
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum Knight para excluir.", "Erro", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonExcluirKnightMouseClicked

    private void jButtonAlterarKnightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAlterarKnightMouseClicked
        if (!knightsList.isEmpty() && currentIndex >= 0 && currentIndex < knightsList.size()) {
            String nomeOriginal = knightsList.get(currentIndex).getNome();

            // Pega os dados dos campos de texto da própria janela para alteração
            int level = 0;
            try {
                level = Integer.parseInt(jTextFieldLevelKnight.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um número válido para o Level.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int skill = 0;
            try {
                skill = Integer.parseInt(jTextFieldSkillKnight.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um número válido para o Skill.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Chama o método alterar do controller
            controller.alterar(nomeOriginal, level, skill);
            JOptionPane.showMessageDialog(this, "Dados do Knight " + nomeOriginal + " alterados com sucesso!");

            // Recarrega a lista para refletir a alteração e exibe os dados atualizados
            carregarKnights();
            exibirKnight();
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum Knight selecionado para alterar.", "Erro", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAlterarKnightMouseClicked

    private void jTextFieldNomeKnightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeKnightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeKnightActionPerformed

    private void jButtonPesquisarKnightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPesquisarKnightMouseClicked
        String nomePesquisa = jTextFieldNomeKnight.getText().trim();
        if (nomePesquisa.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, informe o nome para pesquisar.");
            return;
        }

        Knight foundKnight = controller.buscarPorNome(nomePesquisa);

        if (foundKnight != null) {
            carregarKnights(); // Garante que knightsList está atualizada com os dados mais recentes do BD
            
            int index = -1;
            for (int i = 0; i < knightsList.size(); i++) {
                if (knightsList.get(i).getNome().equalsIgnoreCase(foundKnight.getNome())) {
                    index = i;
                    break;
                }
            }
            
            if (index != -1) {
                currentIndex = index;
                exibirKnight();
                JOptionPane.showMessageDialog(this, "Knight '" + nomePesquisa + "' encontrado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Knight com nome '" + nomePesquisa + "' encontrado no BD, mas não exibido. Tente recarregar a janela.");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Knight com nome '" + nomePesquisa + "' não encontrado.");
            jTextFieldNomeKnight.setText("");
            jTextFieldLevelKnight.setText("");
            jTextFieldSkillKnight.setText("");
        }
    }//GEN-LAST:event_jButtonPesquisarKnightMouseClicked

    private void jButtonPesquisarKnightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarKnightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonPesquisarKnightActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KnightJanela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KnightJanela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KnightJanela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KnightJanela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KnightJanela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonAlterarKnight;
    private javax.swing.JButton jButtonExcluirKnight;
    private javax.swing.JButton jButtonPassarKnight;
    private javax.swing.JButton jButtonPesquisarKnight;
    private javax.swing.JButton jButtonSalvarKnight;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelKnightSalvos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldLevelKnight;
    private javax.swing.JTextField jTextFieldNomeKnight;
    private javax.swing.JTextPane jTextFieldSkillKnight;
    // End of variables declaration//GEN-END:variables
}
