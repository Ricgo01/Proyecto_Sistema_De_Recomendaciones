/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import com.mycompany.proyecto_sistema_recomendaciones.Perro;
import javax.swing.JOptionPane;

/**
 *
 * @author viankacastro
 */
public class Principal2 extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal2() {
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

        BGtamanio = new javax.swing.ButtonGroup();
        BGcolor = new javax.swing.ButtonGroup();
        BGPelo = new javax.swing.ButtonGroup();
        BGpersonalidad = new javax.swing.ButtonGroup();
        BGtoleranciaClima = new javax.swing.ButtonGroup();
        canvas1 = new java.awt.Canvas();
        BAdoptar = new java.awt.Button();
        BAdoptar1 = new java.awt.Button();
        BRegresar = new java.awt.Button();
        BAdoptar3 = new java.awt.Button();
        opcion1JL = new javax.swing.JLabel();
        opcion3JL = new javax.swing.JLabel();
        opcion2JL = new javax.swing.JLabel();
        fondoJL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(canvas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, -1, -1));

        BAdoptar.setActionCommand("BUSCAR");
        BAdoptar.setBackground(new java.awt.Color(228, 176, 139));
        BAdoptar.setFont(new java.awt.Font("Futura", 1, 18)); // NOI18N
        BAdoptar.setForeground(new java.awt.Color(88, 45, 35));
        BAdoptar.setLabel("ADOPTAR");
        BAdoptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAdoptarActionPerformed(evt);
            }
        });
        getContentPane().add(BAdoptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 620, 160, 50));

        BAdoptar1.setActionCommand("BUSCAR");
        BAdoptar1.setBackground(new java.awt.Color(228, 176, 139));
        BAdoptar1.setFont(new java.awt.Font("Futura", 1, 18)); // NOI18N
        BAdoptar1.setForeground(new java.awt.Color(88, 45, 35));
        BAdoptar1.setLabel("ADOPTAR");
        BAdoptar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAdoptar1ActionPerformed(evt);
            }
        });
        getContentPane().add(BAdoptar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 610, 160, 50));

        BRegresar.setActionCommand("BUSCAR");
        BRegresar.setBackground(new java.awt.Color(228, 176, 139));
        BRegresar.setFont(new java.awt.Font("Futura", 1, 18)); // NOI18N
        BRegresar.setForeground(new java.awt.Color(88, 45, 35));
        BRegresar.setLabel("REGRESAR");
        BRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(BRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 720, 160, 50));

        BAdoptar3.setActionCommand("BUSCAR");
        BAdoptar3.setBackground(new java.awt.Color(228, 176, 139));
        BAdoptar3.setFont(new java.awt.Font("Futura", 1, 18)); // NOI18N
        BAdoptar3.setForeground(new java.awt.Color(88, 45, 35));
        BAdoptar3.setLabel("ADOPTAR");
        BAdoptar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAdoptar3ActionPerformed(evt);
            }
        });
        getContentPane().add(BAdoptar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 620, 160, 50));

        opcion1JL.setBackground(new java.awt.Color(153, 255, 204));
        opcion1JL.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"/src/main/java/img/perrito1.png")
        );
        getContentPane().add(opcion1JL, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 260, 330));

        opcion3JL.setBackground(new java.awt.Color(204, 153, 255));
        opcion3JL.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"/src/main/java/img/perrito3.png")
        );
        getContentPane().add(opcion3JL, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 310, 250, 290));

        opcion2JL.setBackground(new java.awt.Color(102, 102, 255));
        opcion2JL.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"/src/main/java/img/perrito2.png")
        );
        getContentPane().add(opcion2JL, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, 260, 290));

        fondoJL.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"/src/main/java/img/GRAFICA2.png")
        );
        getContentPane().add(fondoJL, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 10, 1020, 790));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BAdoptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAdoptarActionPerformed
    
    }//GEN-LAST:event_BAdoptarActionPerformed

    private void BAdoptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAdoptar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BAdoptar1ActionPerformed

    private void BRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BRegresarActionPerformed

    private void BAdoptar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAdoptar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BAdoptar3ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button BAdoptar;
    private java.awt.Button BAdoptar1;
    private java.awt.Button BAdoptar3;
    private javax.swing.ButtonGroup BGPelo;
    private javax.swing.ButtonGroup BGcolor;
    private javax.swing.ButtonGroup BGpersonalidad;
    private javax.swing.ButtonGroup BGtamanio;
    private javax.swing.ButtonGroup BGtoleranciaClima;
    private java.awt.Button BRegresar;
    private java.awt.Canvas canvas1;
    private javax.swing.JLabel fondoJL;
    private javax.swing.JLabel opcion1JL;
    private javax.swing.JLabel opcion2JL;
    private javax.swing.JLabel opcion3JL;
    // End of variables declaration//GEN-END:variables
}
