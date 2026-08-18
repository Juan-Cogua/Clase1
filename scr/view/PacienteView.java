package scr.view;

import javax.swing.JOptionPane;

public class PacienteView {

    public String pedirDato(String mensaje) {
        return JOptionPane.showInputDialog(null, mensaje, "Entrada de Datos", JOptionPane.QUESTION_MESSAGE);
    }

    public boolean confirmar(String mensaje) {
        int respuesta = JOptionPane.showConfirmDialog(null, mensaje, "Confirmación", JOptionPane.YES_NO_OPTION);
        return respuesta == JOptionPane.YES_OPTION;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarError(String mensajeError) {
        JOptionPane.showMessageDialog(null, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public String mostrarMenu() {
        String[] opciones = {
            "1. Registrar Paciente",
            "2. Listar Todos los Pacientes",
            "3. Buscar Paciente por ID",
            "4. Eliminar Paciente",
            "5. Salir"
        };
        return (String) JOptionPane.showInputDialog(
            null,
            "Seleccione una opción:",
            "Sistema de Pacientes",
            JOptionPane.QUESTION_MESSAGE,
            null,
            opciones,
            opciones[0]
        );
    }
}