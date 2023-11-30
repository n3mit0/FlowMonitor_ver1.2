package view;

import javax.swing.JOptionPane;
import model.ArduinoCom;

/**
 *
 * @author berna
 */
public class Home extends javax.swing.JFrame {

    Status estado;
    Alertas alerta;
    AboutUs sobreNosotros;
    ArduinoCom arduino;

    public Home() {
        this.sobreNosotros = new AboutUs();

        this.alerta = new Alertas();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        botAyuda = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        botExit = new javax.swing.JButton();
        botContactUs = new javax.swing.JButton();
        botAboutUs = new javax.swing.JButton();
        botEstado = new javax.swing.JButton();
        botAlertas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panel.setBackground(new java.awt.Color(255, 245, 195));

        botAyuda.setFont(new java.awt.Font("Lucida Bright", 0, 36)); // NOI18N
        botAyuda.setText("?");
        botAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAyudaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 0, 24)); // NOI18N
        jLabel1.setText("Inicio");

        botExit.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        botExit.setText("Salir");
        botExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botExitActionPerformed(evt);
            }
        });

        botContactUs.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        botContactUs.setText("Contáctenos");
        botContactUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botContactUsActionPerformed(evt);
            }
        });

        botAboutUs.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        botAboutUs.setText("Sobre nosotros");
        botAboutUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAboutUsActionPerformed(evt);
            }
        });

        botEstado.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        botEstado.setText("Estado de planta");
        botEstado.setActionCommand("");
        botEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botEstadoActionPerformed(evt);
            }
        });

        botAlertas.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        botAlertas.setText("Alertas");
        botAlertas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAlertasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addComponent(botAboutUs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botContactUs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botAlertas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(botEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botAlertas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botAboutUs, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botContactUs, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botExit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAyudaActionPerformed

    }//GEN-LAST:event_botAyudaActionPerformed

    private void botExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botExitActionPerformed

        dispose();
    }//GEN-LAST:event_botExitActionPerformed

    private void botContactUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botContactUsActionPerformed

    }//GEN-LAST:event_botContactUsActionPerformed

    private void botAboutUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAboutUsActionPerformed

        this.sobreNosotros.setVisible(true);

        dispose();
    }//GEN-LAST:event_botAboutUsActionPerformed

    private void botAlertasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAlertasActionPerformed

        this.alerta.setVisible(true);

        dispose();
    }//GEN-LAST:event_botAlertasActionPerformed

    private void botEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botEstadoActionPerformed
        this.estado = new Status();
        conexion();

        this.estado.setConexion(this.arduino);
        //JOptionPane.showMessageDialog(null, this.arduino.verificarpuerto());
        this.estado.setVisible(true);
        dispose();
    }//GEN-LAST:event_botEstadoActionPerformed

    public void setConexion(ArduinoCom conexion) {
        this.arduino = conexion;
    }

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    private void conexion() {
        if (this.arduino != null) {
            if (this.arduino.verificarpuerto().equals("No conectado")) {
                estado.setConexion("Desconectado");
                //System.out.print("no hay puertos en uso");
                JOptionPane.showMessageDialog(null, "No se ha encontrado ningún puerto de conexión");
                
            } else {
                //JOptionPane.showMessageDialog(null, "Conectado");
                estado.setConexion("Conectado");
            }
        } else {
            JOptionPane.showMessageDialog(null, """
        Conexión vacía""");
            estado.setConexion("Desconectado");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JButton botAboutUs;
    private javax.swing.JButton botAlertas;
    private javax.swing.JButton botAyuda;
    private javax.swing.JButton botContactUs;
    private javax.swing.JButton botEstado;
    private javax.swing.JButton botExit;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
