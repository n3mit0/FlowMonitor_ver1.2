package view;

import java.io.IOException;
import javax.swing.JOptionPane;
import model.ArduinoCom;
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
    private ArduinoCom cone;

    public Status() {

        this.actuCaudal = "";
        this.actuPresion = "";
        this.actuTemperatura = "";
        initComponents();
        this.setLocationRelativeTo(null);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        datoPresion = new javax.swing.JTextField();
        datoTemp = new javax.swing.JTextField();
        datoLlave = new javax.swing.JTextField();
        conexionPlanta = new javax.swing.JLabel();
        botICaudal = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        botRefresh = new javax.swing.JButton();
        botHistorial = new javax.swing.JButton();
        botInicio = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(160, 231, 79));

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        jLabel1.setText("Presión");

        jLabel2.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        jLabel2.setText("Temperatura");

        datoPresion.setEditable(false);
        datoPresion.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        datoPresion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datoPresionActionPerformed(evt);
            }
        });

        datoTemp.setEditable(false);
        datoTemp.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        datoTemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datoTempActionPerformed(evt);
            }
        });

        datoLlave.setEditable(false);
        datoLlave.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        datoLlave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datoLlaveActionPerformed(evt);
            }
        });

        conexionPlanta.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        conexionPlanta.setForeground(new java.awt.Color(255, 51, 51));

        botICaudal.setBackground(new java.awt.Color(255, 255, 153));
        botICaudal.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        botICaudal.setText("Caudal");
        botICaudal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botICaudalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(botICaudal, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(datoPresion)
                                .addComponent(datoTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(datoLlave, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(conexionPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(conexionPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(datoPresion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(datoTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(datoLlave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botICaudal)
                .addGap(30, 30, 30))
        );

        datoPresion.enableInputMethods(false);
        datoTemp.enableInputMethods(false);
        datoLlave.enableInputMethods(false);

        jPanel3.setBackground(new java.awt.Color(255, 102, 51));

        botRefresh.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        botRefresh.setText("Refrescar");
        botRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botRefreshActionPerformed(evt);
            }
        });

        botHistorial.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        botHistorial.setText("Historico");
        botHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botHistorialActionPerformed(evt);
            }
        });

        botInicio.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        botInicio.setText("Inicio");
        botInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botInicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(botHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(botRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(botRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(153, 255, 204));

        jLabel3.setFont(new java.awt.Font("Lucida Bright", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Estado");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        dispose();
    }//GEN-LAST:event_botInicioActionPerformed

    private void botRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botRefreshActionPerformed
        /*
        this.actuCaudal="0";
        this.actuPresion="0";
        this.actuTemperatura="0";*/
        //countDownLatch.countDown();
        if (conexionPlanta.getText().equals("Conectado")) {
            try {
                this.status = new EstadoPlanta(this.cone);
                //countDownLatch.countDown();

                this.actuCaudal = String.valueOf(this.status.caudalActual());
                this.actuPresion = String.valueOf(this.status.presionActual());
                this.actuTemperatura = String.valueOf(this.status.temperaturaActual());

            } catch (InterruptedException ex) {
                System.out.print("Interrupción en la ejecución");
                //Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                System.out.print("Error");
                //Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
            }
            //String press = Float.toString(status.obtenerPresion(Float.parseFloat(dato)));
            if (this.actuCaudal != null && this.actuPresion != null && this.actuTemperatura != null) {

                //datoPresion.setText(press + " psi");
                datoTemp.setText(this.actuTemperatura + " °C");
                datoPresion.setText(this.actuPresion + " psi");
                datoLlave.setText(this.actuCaudal + " rpm");

            } else {
                conexionPlanta.setText("No se pudo leer sensor");
            }
            //Datos presion = new Datos(Float.valueOf());
            //datoTemp.setText(temp + "°C");
        } else {
            JOptionPane.showMessageDialog(null, """
                                                No hay datos de entrada
                                                No hay puertos en uso""");
        }

    }//GEN-LAST:event_botRefreshActionPerformed

    private void botICaudalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botICaudalActionPerformed

        if ((conexionPlanta.getText().equals("Conectado"))) {
            String a = this.cone.obtenerValorSensor("2");
            //countDownLatch.countDown();
            datoLlave.setText(a + "  rpm.");
        } else {
            JOptionPane.showMessageDialog(null, """
        Error en lectura de rpm""");
        }
    }//GEN-LAST:event_botICaudalActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> {
            new Status().setVisible(true);
        });
    }

    public void setConexion(ArduinoCom conexion) {
        this.cone = conexion;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botHistorial;
    private javax.swing.JButton botICaudal;
    private javax.swing.JButton botInicio;
    private javax.swing.JButton botRefresh;
    private javax.swing.JLabel conexionPlanta;
    private javax.swing.JTextField datoLlave;
    private javax.swing.JTextField datoPresion;
    private javax.swing.JTextField datoTemp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
    }
    
    public void setConexion(String valor){
        conexionPlanta.setText(valor);
    }
}
