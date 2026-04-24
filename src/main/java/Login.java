
// Pantalla de inicio

import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author aquin
 */
public class Login extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Login.class.getName());

    /**
     * Creates new form Login
     */
    private int intentos = 0;
    private long bloqueo = 0;

    // Constructor
    public Login() {

        setTitle("Login");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/img/icon.jpg")).getImage());
        initComponents();
        this.pack();
        this.setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Contraseña = new javax.swing.JLabel();
        Usuario = new javax.swing.JLabel();
        Usu = new javax.swing.JTextField();
        Contra = new javax.swing.JPasswordField();
        img = new javax.swing.JLabel();
        Login = new javax.swing.JButton();
        tit = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(231, 249, 249));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Contraseña.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        Contraseña.setText("Contraseña");
        getContentPane().add(Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, -1, -1));

        Usuario.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        Usuario.setText("Usuario");
        getContentPane().add(Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, -1, -1));
        getContentPane().add(Usu, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 190, 40));

        Contra.setText("jPasswordField1");
        getContentPane().add(Contra, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, 190, 40));

        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login/login2.png"))); // NOI18N
        getContentPane().add(img, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 370, -1));

        Login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login/login3.png"))); // NOI18N
        Login.addActionListener(this::LoginActionPerformed);
        getContentPane().add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 480, 290, 70));

        tit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login/login4.png"))); // NOI18N
        getContentPane().add(tit, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, -20, 540, 200));

        jButton1.setBackground(new java.awt.Color(0, 0, 153));
        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SALIR");
        jButton1.setAutoscrolls(true);
        jButton1.addActionListener(this::jButton1ActionPerformed);
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 580, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login/login1.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Botón Login
    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed

        String user = Usu.getText();
        String pass = new String(Contra.getPassword());

        // Verificar bloqueo
        if (System.currentTimeMillis() < bloqueo) {
            JOptionPane.showMessageDialog(null, "Usuario bloqueado por 3 minutos", "Bloqueo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        boolean encontrado = false;

        for (String[] u : Usuarios.usuarios) {

            if (u[1].equals(user) && u[2].equals(pass) && u[4].equals("ACTIVO")) {

                encontrado = true;
                intentos = 0; // reset si acepta el usuario
                Usuarios.Sesion.usuarioActual = user;
                Usuarios.Sesion.rolActual = u[3];
                Menu m = new Menu(user, u[3]);
                m.setLocationRelativeTo(null);
                m.setVisible(true);
                this.dispose();
                return;
            }
        }

        // Si no se encuentra el usuario
        if (!encontrado) {
            intentos++;
            if (intentos >= 3) {
                bloqueo = System.currentTimeMillis() + (3 * 60 * 1000);
                JOptionPane.showMessageDialog(null, "Alcanzaste el límite de intentos\n" + "Bloqueado por 3 minutos", "Bloqueo", JOptionPane.INFORMATION_MESSAGE);
                intentos = 0;
            } else {
                JOptionPane.showMessageDialog(this, "Datos incorrectos. Intento " + intentos);
            }
        }

    }//GEN-LAST:event_LoginActionPerformed

    // Botón Salir
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int out = JOptionPane.showConfirmDialog(this, "¿Quiere salir de la aplicación?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (out == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "GRACIAS POR VENIR", "ADIOS", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Contra;
    private javax.swing.JLabel Contraseña;
    private javax.swing.JButton Login;
    private javax.swing.JTextField Usu;
    private javax.swing.JLabel Usuario;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel img;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel tit;
    // End of variables declaration//GEN-END:variables

} // FIN
