package view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelView.EstadoPlanta;

/**
 *
 * @author berna
 */
public class Status extends javax.swing.JFrame implements Runnable {

    private EstadoPlanta status;
    private String actuTemperatura;
    private String actuPresion;
    private String actuCaudal;

    public Status() {

        this.actuCaudal = "";
        this.actuPresion = "";
        this.actuTemperatura = "";
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botRefresh = new javax.swing.JButton();
        botInicio = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        datoPresion = new javax.swing.JTextField();
        datoTemp = new javax.swing.JTextField();
        botHistorial = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        datoLlave = new javax.swing.JTextField();
        conexionPlanta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(128, 184, 64));

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        jLabel1.setText("Presión");

        jLabel2.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        jLabel2.setText("Temperatura");

        botRefresh.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        botRefresh.setText("Refrescar");
        botRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botRefreshActionPerformed(evt);
            }
        });

        botInicio.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        botInicio.setText("Inicio");
        botInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botInicioActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        jLabel3.setText("Estado");

        datoPresion.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        datoPresion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datoPresionActionPerformed(evt);
            }
        });

        datoTemp.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        datoTemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datoTempActionPerformed(evt);
            }
        });

        botHistorial.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        botHistorial.setText("Historico");
        botHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botHistorialActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        jLabel4.setText("rpm motor");

        datoLlave.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        datoLlave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datoLlaveActionPerformed(evt);
            }
        });

        conexionPlanta.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        conexionPlanta.setForeground(new java.awt.Color(255, 51, 51));
        conexionPlanta.setText("Conectado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
                    .addComponent(botRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(datoPresion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addComponent(datoTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(datoLlave, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(conexionPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(conexionPlanta))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(datoPresion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(datoTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(datoLlave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(botRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        datoPresion.enableInputMethods(false);
        datoTemp.enableInputMethods(false);
        datoLlave.enableInputMethods(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void datoTempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datoTempActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_datoTempActionPerformed

    private void botHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botHistorialActionPerformed
        //mostrar datos
        Historial ventHistorico = new Historial();
        ventHistorico.setVisible(true);

    }//GEN-LAST:event_botHistorialActionPerformed

    private void datoLlaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datoLlaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_datoLlaveActionPerformed

    private void datoPresionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datoPresionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_datoPresionActionPerformed

    private void botInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botInicioActionPerformed
        Home inicio = new Home();
        inicio.setVisible(true);

        dispose();
    }//GEN-LAST:event_botInicioActionPerformed

    private void botRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botRefreshActionPerformed
        //this.sensor = new ArduinoCom();
        //this.status = new Estado();

        //String press = Float.toString(status.obtenerPresion(Float.parseFloat(dato)));
        //datoPresion.setText(press + " psi");
        datoTemp.setText(this.actuTemperatura + " °C");
        datoPresion.setText(this.actuPresion + " psi");
        datoLlave.setText(this.actuCaudal + " rpm");

        //Datos presion = new Datos(Float.valueOf());
        //datoTemp.setText(temp + "°C");

    }//GEN-LAST:event_botRefreshActionPerformed

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
            java.util.logging.Logger.getLogger(Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Status().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botHistorial;
    private javax.swing.JButton botInicio;
    private javax.swing.JButton botRefresh;
    private javax.swing.JLabel conexionPlanta;
    private javax.swing.JTextField datoLlave;
    private javax.swing.JTextField datoPresion;
    private javax.swing.JTextField datoTemp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        try {
            this.status = new EstadoPlanta();

            while (true) {

                this.actuCaudal = String.valueOf(this.status.caudalActual());
                this.actuPresion = String.valueOf(this.status.presionActual());
                this.actuTemperatura = String.valueOf(this.status.temperaturaActual());
                
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
