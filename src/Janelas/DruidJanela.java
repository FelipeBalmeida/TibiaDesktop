/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Janelas;

import Controller.DruidController;
import Model.Druid;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.ArrayList;

public class DruidJanela extends javax.swing.JFrame {

    private DruidController controller = new DruidController();
    private List<Druid> DruidsList = new ArrayList<>();
    private int currentIndex = 0;

    public DruidJanela() {
        initComponents();
        carregarDruids(); // Carregar os druids ao iniciar a janela
        exibirDruid(); // Exibir o primeiro Druid
        setLocationRelativeTo(null);
    }

    private void carregarDruids() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/Personagens/druids.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(",");
                if (dados.length == 3) {
                    String nome = dados[0];
                    int level = Integer.parseInt(dados[1]);
                    int skill = Integer.parseInt(dados[2]);
                    druidsList.add(new Druid(nome, level, skill)); // Usando Druid
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar os druids: " + e.getMessage());
        }
    }

// Exibir o druid atual no JLabel
    private void exibirDruid() {
        if (!druidsList.isEmpty()) {
            Druid currentDruid = druidsList.get(currentIndex);
            jLabelDruidSalvos.setText("Nome: " + currentDruid.getNome()
                    + " | Level: " + currentDruid.getLevel()
                    + " | Skill: " + currentDruid.getMagicLevel());
        } else {
            jLabelDruidSalvos.setText("Nenhum Druid salvo.");
        }
    }

    private void atualizarArquivo() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("src/Personagens/druids.txt"))) {
            for (Druid druid : druidsList) { // Usando Druid
                writer.println(druid.getNome() + "," + druid.getLevel() + "," + druid.getSkill());
            }
            System.out.println("Arquivo druids.txt atualizado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao atualizar o arquivo druids.txt: " + e.getMessage());
        }
}
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSalvarDruid = new javax.swing.JButton();
        jButtonPassarDruid = new javax.swing.JButton();
        jButtonExcluirDruid = new javax.swing.JButton();
        jButtonAlterarDruid = new javax.swing.JButton();
        jLabeld = new javax.swing.JLabel();
        jTextFieldNomeDruid = new javax.swing.JTextField();
        jLabel2d2 = new javax.swing.JLabel();
        jLabeld2d2 = new javax.swing.JLabel();
        jTextFieldLevelDruid = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneSkillDruid = new javax.swing.JTextPane();
        jLabelDruidSalvos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonSalvarDruid.setText("Salvar");
        jButtonSalvarDruid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSalvarDruidMouseClicked(evt);
            }
        });
        jButtonSalvarDruid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarDruidActionPerformed(evt);
            }
        });

        jButtonPassarDruid.setText(">>>");
        jButtonPassarDruid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonPassarDruidMouseClicked(evt);
            }
        });
        jButtonPassarDruid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPassarDruidActionPerformed(evt);
            }
        });

        jButtonExcluirDruid.setText("Excluir");
        jButtonExcluirDruid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonExcluirDruidMouseClicked(evt);
            }
        });

        jButtonAlterarDruid.setText("Alterar");
        jButtonAlterarDruid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAlterarDruidMouseClicked(evt);
            }
        });
        jButtonAlterarDruid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarDruidActionPerformed(evt);
            }
        });

        jLabeld.setText("Nome");

        jLabel2d2.setText("Level");

        jLabeld2d2.setText("Skill");

        jTextFieldLevelDruid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLevelDruidActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jTextPaneSkillDruid);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabeld2d2)
                            .addComponent(jLabeld)
                            .addComponent(jLabel2d2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNomeDruid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldLevelDruid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(100, 100, 100))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonSalvarDruid)
                                .addGap(51, 51, 51)
                                .addComponent(jButtonExcluirDruid))
                            .addComponent(jLabelDruidSalvos, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAlterarDruid)
                            .addComponent(jButtonPassarDruid))
                        .addGap(29, 29, 29))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomeDruid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabeld))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldLevelDruid, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2d2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabeld2d2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonPassarDruid)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAlterarDruid)
                            .addComponent(jButtonExcluirDruid)
                            .addComponent(jButtonSalvarDruid))
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelDruidSalvos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldLevelDruidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLevelDruidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLevelDruidActionPerformed

    private void jButtonAlterarDruidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarDruidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAlterarDruidActionPerformed

    private void jButtonAlterarDruidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAlterarDruidMouseClicked
        if (!druidsList.isEmpty()) {
            // Obtém o knight atual
            Druid currentKnight = DruidsList.get(currentIndex);

            // Solicita ao usuário o novo nome, level e skill
            String novoNome = JOptionPane.showInputDialog(this, "Digite o novo nome:", currentKnight.getNome());
            if (novoNome == null) {
                return; // Se o usuário cancelar a edição
            }
            String novoLevelStr = JOptionPane.showInputDialog(this, "Digite o novo level:", String.valueOf(currentKnight.getLevel()));
            if (novoLevelStr == null) {
                return; // Se o usuário cancelar a edição
            }
            String novoSkillStr = JOptionPane.showInputDialog(this, "Digite a nova skill:", String.valueOf(currentKnight.getSkill()));
            if (novoSkillStr == null) {
                return; // Se o usuário cancelar a edição
            }
            try {
                int novoLevel = Integer.parseInt(novoLevelStr);
                int novoSkill = Integer.parseInt(novoSkillStr);

                // Atualiza os dados do knight
                currentKnight.setNome(novoNome);
                currentKnight.setLevel(novoLevel);
                currentKnight.setSkill(novoSkill);

                // Atualiza a exibição do knight alterado
                exibirDruid();

                // Atualiza o arquivo knights.txt
                atualizarArquivo();

                // Informa ao usuário que a alteração foi realizada com sucesso
                JOptionPane.showMessageDialog(this, "Knight alterado com sucesso!");

            } catch (NumberFormatException e) {
                // Caso o level ou a skill não sejam números válidos
                JOptionPane.showMessageDialog(this, "O level e a skill devem ser números inteiros.");
            }
        } else {
            // Se a lista de knights estiver vazia
            JOptionPane.showMessageDialog(this, "Não há knights para alterar.");
        }
    }//GEN-LAST:event_jButtonAlterarDruidMouseClicked

    private void jButtonExcluirDruidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonExcluirDruidMouseClicked
        if (!DruidsList.isEmpty()) {
            // Excluir o knight atual da lista
            DruidsList.remove(currentIndex);

            // Se a lista não estiver vazia após a exclusão, ajusta o índice
            if (currentIndex >= DruidsList.size()) {
                currentIndex = DruidsList.size() - 1; // Se o índice for maior que o tamanho, vai para o último knight
            }

            // Atualiza a exibição
            exibirDruid();

            // Atualizar o arquivo knights.txt
            atualizarArquivo();
        } else {
            // Se não houver knights, exibe uma mensagem
            JOptionPane.showMessageDialog(this, "Não há knights para excluir.");
        }
    }//GEN-LAST:event_jButtonExcluirDruidMouseClicked

    private void jButtonPassarDruidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPassarDruidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonPassarDruidActionPerformed

    private void jButtonPassarDruidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPassarDruidMouseClicked
        if (!druidsList.isEmpty()) {
            // Incrementar o índice para passar para o próximo druid
            currentIndex = (currentIndex + 1) % druidsList.size(); // Volta ao primeiro druid se ultrapassar o tamanho da lista
            exibirDruid(); // Atualiza a exibição do druid
        }
    }//GEN-LAST:event_jButtonPassarDruidMouseClicked

    private void jButtonSalvarDruidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarDruidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSalvarDruidActionPerformed

    private void jButtonSalvarDruidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSalvarDruidMouseClicked
        // Pega os dados dos campos
        String nome = jTextFieldNomeDruid.getText();
        int level = Integer.parseInt(jTextFieldLevelDruid.getText());
        int skill = Integer.parseInt(jTextPaneSkillDruid.getText());

        // Cria o objeto Druid
        Druid druid = new Druid(nome, level, skill);

        // Salva usando o controller
        controller.salvar(druid);

        // Mensagem de sucesso
        JOptionPane.showMessageDialog(this, "Druid salvo com sucesso!");
    }//GEN-LAST:event_jButtonSalvarDruidMouseClicked

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
            java.util.logging.Logger.getLogger(DruidJanela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DruidJanela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DruidJanela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DruidJanela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DruidJanela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterarDruid;
    private javax.swing.JButton jButtonExcluirDruid;
    private javax.swing.JButton jButtonPassarDruid;
    private javax.swing.JButton jButtonSalvarDruid;
    private javax.swing.JLabel jLabel2d2;
    private javax.swing.JLabel jLabelDruidSalvos;
    private javax.swing.JLabel jLabeld;
    private javax.swing.JLabel jLabeld2d2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldLevelDruid;
    private javax.swing.JTextField jTextFieldNomeDruid;
    private javax.swing.JTextPane jTextPaneSkillDruid;
    // End of variables declaration//GEN-END:variables
}
