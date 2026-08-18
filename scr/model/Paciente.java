package scr.model;

public class Paciente {
    private String id;
    private String nombre;
    private int edad;
    private String diagnostico;

    public Paciente(String id, String nombre, int edad, String diagnostico) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.diagnostico = diagnostico;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getDiagnostico() { return diagnostico; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }

    // Formato CSV delimitado por punto y coma para el archivo .txt
    public String aTextoFormato() {
        return id + ";" + nombre + ";" + edad + ";" + diagnostico;
    }

    // Método estático para construir un Paciente desde una línea de texto
    public static Paciente desdeTextoFormato(String linea) {
        String[] partes = linea.split(";");
        if (partes.length == 4) {
            String id = partes[0];
            String nombre = partes[1];
            int edad = Integer.parseInt(partes[2]);
            String diagnostico = partes[3];
            return new Paciente(id, nombre, edad, diagnostico);
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("ID: %-6s | Nombre: %-20s | Edad: %-3d | Diagnóstico: %s", 
                id, nombre, edad, diagnostico);
    }
}
