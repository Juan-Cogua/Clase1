package scr;

import scr.controller.PacienteController;
import scr.view.PacienteView;
import scr.model.Paciente;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Capa de Control y Capa de Vista desacopladas
        PacienteController controller = new PacienteController("pacientes.txt");
        PacienteView vista = new PacienteView();

        while (true) {
            String opcion = vista.mostrarMenu();

            if (opcion == null) {
                if (vista.confirmar("¿Está seguro de salir?")) {
                    vista.mostrarMensaje("Saliendo del sistema...");
                    break;
                }
                continue;
            }

            opcion = opcion.trim();
            if (opcion.isEmpty()) {
                continue;
            }

            if (opcion.startsWith("5")) {
                if (vista.confirmar("¿Está seguro de salir?")) {
                    vista.mostrarMensaje("Saliendo del sistema...");
                    break;
                }
                continue;
            }

            switch (opcion.charAt(0)) {
                case '1' -> {
                    String id = vista.pedirDato("Ingrese ID del paciente:");
                    if (id == null || id.isBlank()) break;

                    String nombre = vista.pedirDato("Ingrese Nombre:");
                    if (nombre == null || nombre.isBlank()) break;

                    String edadStr = vista.pedirDato("Ingrese Edad:");
                    if (edadStr == null) break;

                    try {
                        int edad = Integer.parseInt(edadStr.trim());
                        String diag = vista.pedirDato("Ingrese Diagnóstico:");

                        boolean exito = controller.registrarPaciente(id, nombre, edad, diag);
                        if (exito) {
                            vista.mostrarMensaje("✓ Paciente guardado con éxito.");
                        } else {
                            vista.mostrarError("✗ El ID ya está registrado.");
                        }
                    } catch (NumberFormatException e) {
                        vista.mostrarError("Error: La edad debe ser un número entero.");
                    }
                }
                case '2' -> {
                    List<Paciente> lista = controller.obtenerTodos();
                    if (lista.isEmpty()) {
                        vista.mostrarMensaje("No hay pacientes registrados.");
                    } else {
                        StringBuilder sb = new StringBuilder("--- REGISTRO DE PACIENTES ---\n\n");
                        lista.forEach(p -> sb.append(p.toString()).append("\n"));
                        vista.mostrarMensaje(sb.toString());
                    }
                }
                case '3' -> {
                    String id = vista.pedirDato("Ingrese ID a buscar:");
                    if (id == null || id.isBlank()) break;

                    Paciente p = controller.buscarPorId(id);
                    if (p != null) {
                        vista.mostrarMensaje("Paciente encontrado:\n\n" + p);
                    } else {
                        vista.mostrarError("No existe paciente con el ID: " + id);
                    }
                }
                case '4' -> {
                    String id = vista.pedirDato("Ingrese ID del paciente a eliminar:");
                    if (id == null || id.isBlank()) break;

                    boolean eliminado = controller.eliminarPaciente(id);
                    if (eliminado) {
                        vista.mostrarMensaje("✓ Paciente eliminado con éxito.");
                    } else {
                        vista.mostrarError("✗ No se encontró paciente con el ID: " + id);
                    }
                }
            }
        }
    }
}