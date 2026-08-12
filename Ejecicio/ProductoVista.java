package Ejecicio;

import javax.swing.JOptionPane;

public class ProductoVista {

    public String pedirDato(String mensaje) {
        return JOptionPane.showInputDialog(null, mensaje, "Entrada de Datos", JOptionPane.QUESTION_MESSAGE);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarError(String mensajeError) {
        JOptionPane.showMessageDialog(null, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
    }
}