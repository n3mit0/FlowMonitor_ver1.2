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
        icon.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        botConectar = new javax.swing.JButton();
        icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panel.setBackground(new java.awt.Color(51, 153, 0));
        Panel.setPreferredSize(new java.awt.Dimension(325, 500));

        botConectar.setBackground(new java.awt.Color(255, 153, 51));
        botConectar.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        botConectar.setForeground(new java.awt.Color(255, 255, 255));
        botConectar.setText("Conectar");
        botConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botConectarActionPerformed(evt);
            }
        });

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/logo_FlowMonitor (200x200).png"))); // NOI18N

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addGap(0, 61, Short.MAX_VALUE)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                        .addComponent(icon)
                        .addGap(16, 16, 16)))
                .addGap(55, 55, 55))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addComponent(icon)
                .addGap(65, 65, 65)
                .addComponent(botConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
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
            //this.ventana.setConexion(this.conexion);
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
    public javax.swing.JButton botConectar;
    public javax.swing.JLabel icon;
    // End of variables declaration//GEN-END:variables
}
