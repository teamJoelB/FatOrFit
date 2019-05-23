/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.fatorfit.ihm;

import fr.fatorfit.dao.UserDao;
import fr.fatorfit.model.User;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ESIC
 */

public class FnConnexion extends javax.swing.JFrame {

    /**
     * Creates new form FnConnexion
     */
    public FnConnexion() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        PanelGauche = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PanelDroit = new javax.swing.JPanel();
        lbIdentifiant = new javax.swing.JLabel();
        txtIdentifiant = new javax.swing.JTextField();
        lbMdp = new javax.swing.JLabel();
        txtMdp = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        btInscription = new javax.swing.JButton();
        btConnexion = new javax.swing.JButton();
        lbMsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelGauche.setBackground(new java.awt.Color(165, 209, 82));

        jLabel1.setFont(new java.awt.Font("Vijaya", 0, 48)); // NOI18N
        jLabel1.setText("Bienvenue sur l'App");

        jLabel2.setFont(new java.awt.Font("Vijaya", 0, 48)); // NOI18N
        jLabel2.setText("Fat or Fit !");

        javax.swing.GroupLayout PanelGaucheLayout = new javax.swing.GroupLayout(PanelGauche);
        PanelGauche.setLayout(PanelGaucheLayout);
        PanelGaucheLayout.setHorizontalGroup(
            PanelGaucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelGaucheLayout.createSequentialGroup()
                .addGroup(PanelGaucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelGaucheLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel1))
                    .addGroup(PanelGaucheLayout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        PanelGaucheLayout.setVerticalGroup(
            PanelGaucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelGaucheLayout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jLabel1)
                .addGap(74, 74, 74)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbIdentifiant.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbIdentifiant.setText("Identifiant :");

        lbMdp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbMdp.setText("Mot de passe :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Pas encore de compte ?");

        btInscription.setText("Inscription");
        btInscription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInscriptionActionPerformed(evt);
            }
        });

        btConnexion.setText("Connexion");
        btConnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConnexionActionPerformed(evt);
            }
        });

        lbMsg.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout PanelDroitLayout = new javax.swing.GroupLayout(PanelDroit);
        PanelDroit.setLayout(PanelDroitLayout);
        PanelDroitLayout.setHorizontalGroup(
            PanelDroitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDroitLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(btConnexion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btInscription)
                .addGap(107, 107, 107))
            .addGroup(PanelDroitLayout.createSequentialGroup()
                .addGroup(PanelDroitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDroitLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(PanelDroitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMdp, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelDroitLayout.createSequentialGroup()
                                .addComponent(txtMdp, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(jLabel3))
                            .addComponent(lbIdentifiant)
                            .addComponent(txtIdentifiant, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelDroitLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(lbMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        PanelDroitLayout.setVerticalGroup(
            PanelDroitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDroitLayout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(lbIdentifiant)
                .addGap(18, 18, 18)
                .addComponent(txtIdentifiant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbMdp)
                .addGroup(PanelDroitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDroitLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtMdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(PanelDroitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btConnexion)
                            .addComponent(btInscription)))
                    .addGroup(PanelDroitLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel3)))
                .addGap(32, 32, 32)
                .addComponent(lbMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(PanelGauche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelDroit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelGauche, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelDroit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btInscriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInscriptionActionPerformed
       FnInscription2 fnIn = new FnInscription2();
       fnIn.setVisible(true);
        this.setVisible(false); /*Ferme la fenêtre de connexion*/
    }//GEN-LAST:event_btInscriptionActionPerformed

    private void btConnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConnexionActionPerformed
        String identifiant = txtIdentifiant.getText();
        String mdp = txtMdp.getText();
        User user=null;
        
        try{
            user = UserDao.getByLoginPass(identifiant, mdp);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
        if(user!=null){
               
                FnPrincipal fnp = new FnPrincipal(user);
                java.util.Date derCo=null; 
                try {
                    derCo = UserDao.getDerniereConnexion(user);
                } catch (SQLException e) {
                     JOptionPane.showMessageDialog(rootPane, e.getMessage());
                }
                if (derCo==null){
                    FnDecouverte fnd = new FnDecouverte(user);
                    fnd.setVisible(true);
                }
                fnp.setVisible(true);           
                this.setVisible(false);
        }
        else{
             lbMsg.setText("Identifiant ou mot de passe incorrect !");
        }
        
        
    }//GEN-LAST:event_btConnexionActionPerformed

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
            java.util.logging.Logger.getLogger(FnConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FnConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FnConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FnConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FnConnexion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelDroit;
    private javax.swing.JPanel PanelGauche;
    private javax.swing.JButton btConnexion;
    private javax.swing.JButton btInscription;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbIdentifiant;
    private javax.swing.JLabel lbMdp;
    private javax.swing.JLabel lbMsg;
    private javax.swing.JTextField txtIdentifiant;
    private javax.swing.JPasswordField txtMdp;
    // End of variables declaration//GEN-END:variables
}
