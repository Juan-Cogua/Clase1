package scr.controller;

import scr.model.Paciente;
import scr.loaders.PacienteLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PacienteController {
    private List<Paciente> listaPacientes;
    private PacienteLoader loader;

    public PacienteController(String rutaArchivo) {
        this.loader = new PacienteLoader(rutaArchivo);
        this.listaPacientes = new ArrayList<>();
        cargarDesdeArchivo(); // Carga automática al iniciar
    }

    public boolean registrarPaciente(String id, String nombre, int edad, String diagnostico) {
        // Validación de ID duplicado
        if (buscarPorId(id) != null) {
            return false;
        }
        Paciente nuevo = new Paciente(id, nombre, edad, diagnostico);
        listaPacientes.add(nuevo);
        guardarEnArchivo();
        return true;
    }

    public List<Paciente> obtenerTodos() {
        return listaPacientes;
    }

    public Paciente buscarPorId(String id) {
        for (Paciente p : listaPacientes) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }
    
    public boolean eliminarPaciente(String id) {
        Paciente p = buscarPorId(id);
        if (p != null) {
            listaPacientes.remove(p);
            guardarEnArchivo();
            return true;
        }
        return false;
    }

    public void guardarEnArchivo() {
        try {
            loader.guardar(listaPacientes);
        } catch (IOException e) {
            System.err.println("Error al guardar en el archivo: " + e.getMessage());
        }
    }

    public void cargarDesdeArchivo() {
        try {
            this.listaPacientes = loader.cargar();
        } catch (IOException e) {
            System.err.println("Error al cargar del archivo: " + e.getMessage());
        }
    }
}