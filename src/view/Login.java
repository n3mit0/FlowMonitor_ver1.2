package view;

import javax.swing.JOptionPane;
import model.ArduinoCom;

/**
 *
 * @author berna
 */
public class Login extends javax.swing.JFrame {

    private final ArduinoCom conexion;
    public Home ventana;

    public Login() {
        this.conexion = new ArduinoCom();
        this.ventana = new Home();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        botConectar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panel.setBackground(new java.awt.Color(108, 205, 241));
        Panel.setPreferredSize(new java.awt.Dimension(325, 500));

        botConectar.setBackground(new java.awt.Color(243, 0, 33));
        botConectar.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        botConectar.setForeground(new java.awt.Color(255, 255, 255));
        botConectar.setText("Conectar");
        botConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botConectarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(botConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addContainerGap(238, Short.MAX_VALUE)
                .addComponent(botConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(219, 219, 219))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botConectarActionPerformed

        String sp = conexion.conexionpuerto();

        if ("Ningún puerto en uso".equals(sp)) {
            System.out.print("no hay puertos en uso");
            JOptionPane.showMessageDialog(null, "No se ha encontrado ningún puerto de conexión");
            this.ventana.setConexion(this.conexion);
            this.ventana.setVisible(true);
            dispose();
        } else {
            this.ventana.setConexion(this.conexion);
            this.ventana.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_botConectarActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JButton botConectar;
    // End of variables declaration//GEN-END:variables
}
