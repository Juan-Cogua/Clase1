package scr.loaders;

import scr.model.Paciente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteLoader {
    private final String rutaArchivo;

    public PacienteLoader(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    // Escribir lista de pacientes al archivo .txt
    public void guardar(List<Paciente> pacientes) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Paciente p : pacientes) {
                writer.write(p.aTextoFormato());
                writer.newLine();
            }
        }
    }

    // Leer archivo .txt y reconstruir lista de pacientes
    public List<Paciente> cargar() throws IOException {
        List<Paciente> pacientes = new ArrayList<>();
        File archivo = new File(rutaArchivo);

        if (!archivo.exists()) {
            return pacientes; // Retorna lista vacía si aún no existe el archivo
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    Paciente p = Paciente.desdeTextoFormato(linea);
                    if (p != null) {
                        pacientes.add(p);
                    }
                }
            }
        }
        return pacientes;
    }
}
