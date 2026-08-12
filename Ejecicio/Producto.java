package Ejecicio;

public class Producto {
    private String codigo;
    private String nombre;
    private double precio;

    public Producto(String codigo, String nombre, double precio) {
        if (codigo == null || codigo.isBlank()) throw new IllegalArgumentException("El código no puede estar vacío.");
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("El nombre no puede estar vacío.");
        if (precio <= 0) throw new IllegalArgumentException("El precio debe ser mayor a 0.");

        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }

    public String aTexto() {
        return codigo + ";" + nombre + ";" + (long) precio;
    }
}