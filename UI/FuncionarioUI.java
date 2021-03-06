/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BAL.FuncionarioBAL;
import DAO.FuncionarioDAO;
import VO.FuncionarioVO;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.channels.FileChannel;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Manu
 */
public class FuncionarioUI extends javax.swing.JFrame {

    MaskFormatter formatoNasc;


    /**
     * Creates new form FuncionarioUI
     */
    public FuncionarioUI() throws SQLException {
        initComponents();
        this.Carregar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_id = new javax.swing.JLabel();
        lbl_nome = new javax.swing.JLabel();
        lbl_nasc = new javax.swing.JLabel();
        lbl_sal = new javax.swing.JLabel();
        lbl_foto = new javax.swing.JLabel();
        lbl_exibe_foto = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_nome = new javax.swing.JTextField();
        try{
            formatoNasc = new MaskFormatter("##/##/####");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "não é´possível usar formatador");
        }
        txt_nasc = new JFormattedTextField(formatoNasc);
        ;
        txt_sal = new javax.swing.JTextField();
        txt_foto = new javax.swing.JTextField();
        btn_inserir = new javax.swing.JButton();
        btn_salvar = new javax.swing.JButton();
        btn_excluir = new javax.swing.JButton();
        btn_foto = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_id.setText("ID");

        lbl_nome.setText("Nome");

        lbl_nasc.setText("Nascimento");

        lbl_sal.setText("Salário");
        lbl_sal.setToolTipText("");

        lbl_foto.setText("foto");

        txt_nasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nascActionPerformed(evt);
            }
        });

        btn_inserir.setText("Inserir");
        btn_inserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inserirActionPerformed(evt);
            }
        });

        btn_salvar.setText("Salvar");
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });

        btn_excluir.setText("Excluir");
        btn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirActionPerformed(evt);
            }
        });

        btn_foto.setText("Procurar");
        btn_foto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_inserir)
                        .addGap(18, 18, 18)
                        .addComponent(btn_salvar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_excluir)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_id)
                            .addComponent(lbl_nome)
                            .addComponent(lbl_nasc)
                            .addComponent(lbl_sal)
                            .addComponent(lbl_foto))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_id, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                    .addComponent(txt_sal)
                                    .addComponent(txt_foto))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_foto))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_nasc, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_nome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(lbl_exibe_foto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_id)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nome)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nasc)
                    .addComponent(txt_nasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_sal)
                    .addComponent(txt_sal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_foto)
                    .addComponent(txt_foto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_foto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_inserir)
                    .addComponent(btn_salvar)
                    .addComponent(btn_excluir)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(lbl_exibe_foto, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nome", "Nasc", "Salario", "lfoto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setToolTipText("");
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(329, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_inserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inserirActionPerformed
        // TODO add your handling code here:
        BigDecimal sal = null;
        String nome = null;
        Date nasc = null;
        int retorno;
        try {

            FuncionarioBAL funBAL = new FuncionarioBAL();

            nome = funBAL.VerificarNome(txt_nome.getText());
            nasc = funBAL.VerificarNasc(txt_nasc.getText());
            sal = funBAL.VerificarSal(txt_sal.getText());

            
             
            
            FuncionarioVO funVO = new FuncionarioVO(nome, nasc, sal,nome+".jpg");

            retorno = funBAL.Inserir(funVO);

            if (retorno == 1) {
                JOptionPane.showMessageDialog(null,
                        "Inserido Com sucesso\n"
                        + "nome: " + nome + "\n"
                        + "nasc: " + nasc.toString() + "\n"
                        + "sal :" + sal.toString()
                );
            
            this.Carregar();
            }
            
         
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro: " + e.getMessage());

        }

    }//GEN-LAST:event_btn_inserirActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked

        txt_id.setText(tabela.getModel().getValueAt(tabela.getSelectedRow(), 0).toString());
        txt_nome.setText(tabela.getModel().getValueAt(tabela.getSelectedRow(), 1).toString());
        txt_nasc.setText(tabela.getModel().getValueAt(tabela.getSelectedRow(), 2).toString());
        
        
        
        
        txt_sal.setText(tabela.getModel().getValueAt(tabela.getSelectedRow(), 3).toString());
        txt_foto.setText(tabela.getModel().getValueAt(tabela.getSelectedRow(), 4).toString());
        
      //  StringBuilder img = null;
        //img.append("src//imagens//");
        //img.append( tabela.getModel().getValueAt(tabela.getSelectedRow(), 1).toString());
       //img.append(".jpg");
               
        String img ="./src/imagens/"+tabela.getModel().getValueAt(tabela.getSelectedRow(), 1).toString()+".jpg";
        ImageIcon iconLogo = new ImageIcon(img);
        lbl_exibe_foto.setIcon(iconLogo);
        
        
    }//GEN-LAST:event_tabelaMouseClicked

    private void limpar() {
        txt_id.setText("");
        txt_nome.setText("");
        txt_sal.setText("");
        txt_nasc.setText("");
        txt_foto.setText("");
    }

    private void txt_nascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nascActionPerformed


    }//GEN-LAST:event_txt_nascActionPerformed

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed
        FuncionarioBAL funBAL = new FuncionarioBAL();
        int retorno = 0;

        try {
            retorno = funBAL.Excluir(txt_id.getText());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        if (retorno == 1) {
            JOptionPane.showMessageDialog(null, txt_nome.getText() + " Excluido com sucesso");
            this.limpar();

            DefaultTableModel tab = (DefaultTableModel) tabela.getModel();
            tab.removeRow(tabela.getSelectedRow());
        }
    }//GEN-LAST:event_btn_excluirActionPerformed

    private void btn_fotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fotoActionPerformed
        
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        
        File f = chooser.getSelectedFile();    
                
        String filename = f.getAbsolutePath();
        txt_foto.setText(filename);        
        File copia = new File("./src/imagens/"+txt_nome.getText()+".jpg");  
         if(!copia.exists())       
                copiar(f,copia);  
      
    }//GEN-LAST:event_btn_fotoActionPerformed

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        // TODO add your handling code here:
        BigDecimal sal = null;
        String nome = null;
        Date nasc = null;
        int retorno;
        try {

            FuncionarioBAL funBAL = new FuncionarioBAL();

            nome = funBAL.VerificarNome(txt_nome.getText());
            nasc = funBAL.VerificarNasc(txt_nasc.getText());
            sal = funBAL.VerificarSal(txt_sal.getText());

            
                     
            FuncionarioVO funVO = new FuncionarioVO(nome, nasc, sal,nome+".jpg");

            retorno = funBAL.Editar(txt_id.getText(),funVO);

            if (retorno == 1) {
                JOptionPane.showMessageDialog(null,
                        "Editado Com sucesso\n"
                        + "nome: " + nome + "\n"
                        + "nasc: " + nasc.toString() + "\n"
                        + "sal :" + sal.toString()
                );
            
            this.Carregar();
            }
            
         
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro: " + e.getMessage());

        }
    }//GEN-LAST:event_btn_salvarActionPerformed

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
            java.util.logging.Logger.getLogger(FuncionarioUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FuncionarioUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FuncionarioUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FuncionarioUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FuncionarioUI().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_foto;
    private javax.swing.JButton btn_inserir;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_exibe_foto;
    private javax.swing.JLabel lbl_foto;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_nasc;
    private javax.swing.JLabel lbl_nome;
    private javax.swing.JLabel lbl_sal;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txt_foto;
    private javax.swing.JTextField txt_id;
    private javax.swing.JFormattedTextField txt_nasc;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_sal;
    // End of variables declaration//GEN-END:variables

    private void Carregar() throws SQLException {
        DefaultTableModel tab = (DefaultTableModel) tabela.getModel();
        tab.setNumRows(0);

        FuncionarioDAO funDAO = new FuncionarioDAO();

        ResultSet rs = funDAO.Listar();

        while (rs.next()) {

            String id = String.valueOf(rs.getInt("id"));
            String nome = rs.getString("nome");

            String nasc = rs.getDate("nasc").toString();
            String sal = rs.getBigDecimal("salario").toString();
            String foto = rs.getString("foto");

            tab.addRow(
                    new String[]{
                        id, nome, nasc, sal,foto

                    }
                    
            );

        }
        
    }
    
    public void copiar(File fonte, File destino) {
        try {
            FileChannel in = new FileInputStream(fonte).getChannel();
            FileChannel out = new FileOutputStream(destino).getChannel();
            out.transferFrom(in, 0, in.size());

            in.close();
            out.close();

        } catch (IOException ex) {

        }
    }
}
