package view;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import javax.swing.JOptionPane;
import model.ArduinoCom;
import modelView.EstadoPlanta;

/**
 *
 * @author berna
 */
public class Status extends javax.swing.JFrame implements Runnable {
    
    private static final CountDownLatch countDownLatch = new CountDownLatch(5);
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
        conexion();

    }

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
        datoLlave = new javax.swing.JTextField();
        conexionPlanta = new javax.swing.JLabel();
        botICaudal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(160, 231, 79));

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

        botHistorial.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        botHistorial.setText("Historico");
        botHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botHistorialActionPerformed(evt);
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
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(botHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
                            .addComponent(botRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botICaudal, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(datoPresion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                .addComponent(datoTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(datoLlave, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(conexionPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(conexionPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(datoPresion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(datoTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datoLlave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botICaudal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
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
        countDownLatch.countDown();
        if (conexionPlanta.getText().equals("Conectado")) {
            try {
                this.status = new EstadoPlanta();

                while (true) {

                    this.actuCaudal = String.valueOf(this.status.caudalActual());
                    this.actuPresion = String.valueOf(this.status.presionActual());
                    this.actuTemperatura = String.valueOf(this.status.temperaturaActual());

                }

            } catch (InterruptedException ex) {
                System.out.print("Interrupción en la ejecución");
                //Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                System.out.print("Error");
                //Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
            }
            //String press = Float.toString(status.obtenerPresion(Float.parseFloat(dato)));
            //datoPresion.setText(press + " psi");
            datoTemp.setText(this.actuTemperatura + " °C");
            datoPresion.setText(this.actuPresion + " psi");
            //datoLlave.setText(this.actuCaudal + " rpm");

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
            cone = new ArduinoCom();
            if ((cone.obtenerValorSensor(2) != null)|| (!"".equals(cone.puerto()))) {
                datoLlave.setText(cone.obtenerValorSensor(2) + "  .");
            } else {
                JOptionPane.showMessageDialog(null, """
                                                Error en lectura de caudal""");
            }
        } else {
            JOptionPane.showMessageDialog(null, """
                                                No hay datos de entrada
                                                No hay puertos en uso""");
        }
    }//GEN-LAST:event_botICaudalActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> {
            new Status().setVisible(true);
        });
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
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
    }

    private void conexion() {
        cone = new ArduinoCom();
        String sp = cone.puerto();

        if ("".equals(sp)) {
            System.out.print("no hay puertos en uso");
            //JOptionPane.showMessageDialog(null, "No se ha encontrado ningún puerto de conexión");
            conexionPlanta.setText("Desconectado");
        } else {
            conexionPlanta.setText("Conectado");
        }
    }
}
