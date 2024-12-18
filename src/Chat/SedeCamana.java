package Chat;

import java.io.*;
import java.net.*;
import javax.swing.*;

public class SedeCamana extends javax.swing.JFrame {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public SedeCamana() {
        initComponents();
        iniciarServidor();
    }

    private void iniciarServidor() {
        try {
            serverSocket = new ServerSocket(6000); // Puerto de Sede Camana
            new Thread(() -> {
                while (true) {
                    try {
                        clientSocket = serverSocket.accept();
                        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        String mensajeRecibido = in.readLine();
                        dondEstaranMensajes.append("" + mensajeRecibido + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error iniciando el servidor: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombreUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        EscribirMensaje = new javax.swing.JTextField();
        enviarMensaje = new javax.swing.JButton();
        limpiarMensaje = new javax.swing.JButton();
        salirVentana = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dondEstaranMensajes = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Sede Camana");

        jLabel2.setText("Usuario:");

        jLabel3.setText("Escribe tu texto aqui:");

        enviarMensaje.setText("Enviar mensaje");
        enviarMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarMensajeActionPerformed(evt);
            }
        });

        limpiarMensaje.setText("Limpiar Mensaje");
        limpiarMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarMensajeActionPerformed(evt);
            }
        });

        salirVentana.setText("Salir Ventana");
        salirVentana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirVentanaActionPerformed(evt);
            }
        });

        dondEstaranMensajes.setColumns(20);
        dondEstaranMensajes.setRows(5);
        jScrollPane1.setViewportView(dondEstaranMensajes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(nombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                            .addComponent(EscribirMensaje)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(enviarMensaje)
                                    .addComponent(limpiarMensaje)
                                    .addComponent(salirVentana)
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1)
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EscribirMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(enviarMensaje)
                        .addGap(18, 18, 18)
                        .addComponent(limpiarMensaje)
                        .addGap(18, 18, 18)
                        .addComponent(salirVentana)))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enviarMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarMensajeActionPerformed

        try {
            String usuario = nombreUsuario.getText();  // Obtener el nombre del usuario
            String mensaje = EscribirMensaje.getText();  // Obtener el mensaje del cuadro de texto
            if (!usuario.isEmpty() && !mensaje.isEmpty()) {
                String mensajeCompleto = usuario + ": " + mensaje;  // Crear el mensaje completo con el nombre del usuario
                Socket socket = new Socket("localhost", 5000); // Puerto de Sede Mollendo
                out = new PrintWriter(socket.getOutputStream(), true);
                out.println(mensajeCompleto);  // Enviar el mensaje completo
                dondEstaranMensajes.append("" + mensajeCompleto + "\n");  // Mostrar el mensaje con el nombre del usuario
                EscribirMensaje.setText("");  // Limpiar el campo de mensaje
                socket.close();
            } else {
                JOptionPane.showMessageDialog(this, "Debe ingresar un usuario y un mensaje.");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error enviando el mensaje: " + e.getMessage());
        }
    }//GEN-LAST:event_enviarMensajeActionPerformed

    private void limpiarMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarMensajeActionPerformed

        EscribirMensaje.setText("");
        dondEstaranMensajes.setText("");
    }//GEN-LAST:event_limpiarMensajeActionPerformed

    private void salirVentanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirVentanaActionPerformed

        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_salirVentanaActionPerformed

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
            java.util.logging.Logger.getLogger(SedeCamana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SedeCamana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SedeCamana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SedeCamana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SedeCamana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EscribirMensaje;
    private javax.swing.JTextArea dondEstaranMensajes;
    private javax.swing.JButton enviarMensaje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiarMensaje;
    private javax.swing.JTextField nombreUsuario;
    private javax.swing.JButton salirVentana;
    // End of variables declaration//GEN-END:variables
}
