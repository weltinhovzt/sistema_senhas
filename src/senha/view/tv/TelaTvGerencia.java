package senha.view.tv;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import senha.control.MediaHelper;
import senha.control.AtualizadorComponentsGerencia;
import senha.control.AtualizadorHorario;


/**
 *
 * @author welti_000
 */
public class TelaTvGerencia extends javax.swing.JFrame {

    
    boolean emExecucao = true;

    /**
     * Creates new form TelaPrincipal
     */
    public TelaTvGerencia() {
        initComponents();

        AtualizadorHorario horario = new AtualizadorHorario();
        jLData.setText(horario.dataSistema());
        AtualizadorHorario.horaSistema(jLHora);
        AtualizadorComponentsGerencia.atualizarCompents(jLSenha, jLGuiche, jLultimaSenha1,
                jLGuiche1,jLultimaSenha2,jLGuiche2,jLultimaSenha3,jLGuiche3,jLultimaSenha4,jLGuiche4);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLSenha = new javax.swing.JLabel();
        jLGuiche = new javax.swing.JLabel();
        jLData = new javax.swing.JLabel();
        jLHora = new javax.swing.JLabel();
        jLGuiche3 = new javax.swing.JLabel();
        jLultimaSenha4 = new javax.swing.JLabel();
        jLultimaSenha2 = new javax.swing.JLabel();
        jLGuiche4 = new javax.swing.JLabel();
        jLultimaSenha3 = new javax.swing.JLabel();
        jLGuiche2 = new javax.swing.JLabel();
        jLGuiche1 = new javax.swing.JLabel();
        jLultimaSenha1 = new javax.swing.JLabel();
        jLFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1360, 768));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jLSenha.setFont(new java.awt.Font("Tahoma", 1, 210)); // NOI18N
        jLSenha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLSenha.setText("GC000");
        jLSenha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jLSenhaPropertyChange(evt);
            }
        });
        getContentPane().add(jLSenha);
        jLSenha.setBounds(30, 140, 740, 400);

        jLGuiche.setFont(new java.awt.Font("Tahoma", 1, 210)); // NOI18N
        jLGuiche.setForeground(new java.awt.Color(255, 255, 255));
        jLGuiche.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLGuiche.setText("00");
        getContentPane().add(jLGuiche);
        jLGuiche.setBounds(810, 140, 530, 410);

        jLData.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLData.setText("06/07/2015");
        getContentPane().add(jLData);
        jLData.setBounds(1240, 640, 110, 20);

        jLHora.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLHora.setText("21:29:00");
        getContentPane().add(jLHora);
        jLHora.setBounds(1250, 560, 100, 70);

        jLGuiche3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLGuiche3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLGuiche3);
        jLGuiche3.setBounds(750, 620, 140, 40);

        jLultimaSenha4.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        jLultimaSenha4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLultimaSenha4);
        jLultimaSenha4.setBounds(950, 570, 180, 50);

        jLultimaSenha2.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        jLultimaSenha2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLultimaSenha2);
        jLultimaSenha2.setBounds(510, 570, 180, 50);

        jLGuiche4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLGuiche4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLGuiche4);
        jLGuiche4.setBounds(970, 620, 140, 40);

        jLultimaSenha3.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        jLultimaSenha3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLultimaSenha3);
        jLultimaSenha3.setBounds(730, 570, 180, 50);

        jLGuiche2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLGuiche2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLGuiche2);
        jLGuiche2.setBounds(530, 620, 140, 40);

        jLGuiche1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLGuiche1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLGuiche1);
        jLGuiche1.setBounds(310, 620, 140, 40);

        jLultimaSenha1.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        jLultimaSenha1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLultimaSenha1);
        jLultimaSenha1.setBounds(290, 570, 180, 50);

        jLFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/senha/img/LayoutTV2.png"))); // NOI18N
        jLFundo.setMaximumSize(new java.awt.Dimension(1360, 768));
        jLFundo.setMinimumSize(new java.awt.Dimension(1360, 768));
        jLFundo.setPreferredSize(new java.awt.Dimension(1360, 768));
        getContentPane().add(jLFundo);
        jLFundo.setBounds(0, 0, 1360, 770);
    }// </editor-fold>//GEN-END:initComponents

    private void jLSenhaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jLSenhaPropertyChange

        MediaHelper.initSom(getClass().getResource("/senha/audio/alerta.wav").toString());
    }//GEN-LAST:event_jLSenhaPropertyChange

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
            java.util.logging.Logger.getLogger(TelaTvGerencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaTvGerencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaTvGerencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaTvGerencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaTvGerencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLData;
    private javax.swing.JLabel jLFundo;
    private javax.swing.JLabel jLGuiche;
    private javax.swing.JLabel jLGuiche1;
    private javax.swing.JLabel jLGuiche2;
    private javax.swing.JLabel jLGuiche3;
    private javax.swing.JLabel jLGuiche4;
    private javax.swing.JLabel jLHora;
    private javax.swing.JLabel jLSenha;
    private javax.swing.JLabel jLultimaSenha1;
    private javax.swing.JLabel jLultimaSenha2;
    private javax.swing.JLabel jLultimaSenha3;
    private javax.swing.JLabel jLultimaSenha4;
    // End of variables declaration//GEN-END:variables
    
    
}
