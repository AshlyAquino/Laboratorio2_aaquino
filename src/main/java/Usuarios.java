
//Clase donde se encuentran todos los métodos utilizados en el código, además tiene los usuarios registrados previamente

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ashly
 */
public class Usuarios {

    // Contador inicia en 10000 (5 dígitos)
    public static int idCounter = 10000;

    // Método para generar ID único secuencial
    public static String generarID() {
        return String.valueOf(idCounter++);
    }
    // -------------------------- USUARIOS REGISTRADOS -------------------------

    // ID | Usuario | Password | Rol | Estado
    public static String[][] usuarios = {
        {generarID(), "aaquino", "Umariano24", "Encargado", "ACTIVO"},
        {generarID(), "jtorres", "Umariano24", "Empleado", "ACTIVO"},
        {generarID(), "mcabrera", "Umariano24", "Supervisor", "ACTIVO"},
        {generarID(), "jrodriguez", "Umariano24", "Empleado", "ACTIVO"},
        {generarID(), "mruano", "Umariano24", "Empleado", "ACTIVO"}

    };

    // -------------------------- MÉTODOS DE APOYO GENERAL -------------------------
    // Validar lineamientos de contraseña
    public static String validarPassword(String pass) {

        if (pass.length() < 13) {
            return "La contraseña debe tener al menos 13 caracteres.";
        }

        if (!pass.matches(".*[A-Z].*")) {
            return "La contraseña debe incluir al menos una letra mayúscula.";
        }

        if (!pass.matches(".*[0-9].*")) {
            return "La contraseña debe incluir al menos un número.";
        }

        if (!pass.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*")) {
            return "La contraseña debe incluir al menos un símbolo.";
        }

        return null; // válida

    }

    // Cargar usuarios a la tabla
    public static void cargarTabla(javax.swing.JTable tabla) {

        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        for (String[] u : usuarios) {
            modelo.addRow(new Object[]{
                u[0], u[1], u[2], u[3], u[4]
            });
        }
    }

    // Limpiar campos
    public static void limpiarCampos(javax.swing.JTextField... campos) {

        for (javax.swing.JTextField campo : campos) {
            campo.setText("");
        }

    }

    // Limpiar contraseña
    public static void limpiarPassword(javax.swing.JPasswordField... campos) {

        for (javax.swing.JPasswordField campo : campos) {
            campo.setText("");
        }

    }

    // Guardar usuario en sesión
    public static class Sesion {

        public static String usuarioActual;
        public static String rolActual;

    }

    // Logout
    public static void cerrarSesion(javax.swing.JFrame ventanaActual) {

        int r = javax.swing.JOptionPane.showConfirmDialog(
                ventanaActual,
                "¿Cerrar sesión?",
                "Confirmar",
                javax.swing.JOptionPane.YES_NO_OPTION
        );

        if (r == javax.swing.JOptionPane.YES_OPTION) {

            Usuarios.Sesion.usuarioActual = null;
            Usuarios.Sesion.rolActual = null;
            new Login().setVisible(true);
            ventanaActual.dispose();
        }

    }

    // Regresar al menú principal
    public static void regresarMenu(javax.swing.JFrame ventanaActual) {

        int rmp = javax.swing.JOptionPane.showConfirmDialog(
                ventanaActual,
                "¿Quieres regresar al Menú Principal?",
                "Confirmar",
                javax.swing.JOptionPane.YES_NO_OPTION
        );

        if (rmp == javax.swing.JOptionPane.YES_OPTION) {

            for (java.awt.Window w : java.awt.Window.getWindows()) {
                if (w != ventanaActual) {
                    w.dispose();
                }
            }
            ventanaActual.dispose();
            new Menu(Sesion.usuarioActual, Sesion.rolActual)
                    .setVisible(true);
        }

    }

} // FIN 
