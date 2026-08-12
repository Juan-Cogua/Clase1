package Ejecicio;

import java.io.IOException;

public class ProductoController {
    private final ProductoVista vista;
    private final ProductoLoader loader;

    public ProductoController(ProductoVista vista, ProductoLoader loader) {
        this.vista = vista;
        this.loader = loader;
    }
    public void registrarProducto() {
        try {
            String codigo = vista.pedirDato("Ingrese el código del producto:");
            if (codigo == null) return; 

            String nombre = vista.pedirDato("Ingrese el nombre del producto:");
            if (nombre == null) return;

            String precioTexto = vista.pedirDato("Ingrese el precio del producto:");
            if (precioTexto == null) return;

            double precio = Double.parseDouble(precioTexto);

            Producto producto = new Producto(codigo, nombre, precio);

            loader.guardar(producto);

            vista.mostrarMensaje("¡Producto " + producto.getNombre() + " guardado con éxito!");

        } catch (NumberFormatException e) {
            vista.mostrarError("El precio ingresado no es un número válido.");
        } catch (IllegalArgumentException e) {
            vista.mostrarError("Error en los datos: " + e.getMessage());
        } catch (IOException e) {
            vista.mostrarError("Error al guardar en el archivo: " + e.getMessage());
        }
    }
}