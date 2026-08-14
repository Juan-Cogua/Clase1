package Ejecicio.Cotroller;

import Ejecicio.Loader.ProductoLoader;
import Ejecicio.Vista.ProductoVista;
import Ejecicio.model.Producto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductoController {
    private final ProductoVista vista;
    private final ProductoLoader loader;

    public ProductoController(ProductoVista vista, ProductoLoader loader) {
        this.vista = vista;
        this.loader = loader;
    }
    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            String opcion = vista.pedirDato("Seleccione una opción:\n1. Registrar producto\n2. Ver productos\n3. Salir");
            if (opcion == null) return; 
            switch (opcion) {
                case "1":
                    registrarProducto();
                    break;
                case "2":
                    verProductos();
                    break;
                case "3":
                    salir = true;
                    break;
                default:
                    vista.mostrarError("Opción no válida. Por favor, intente de nuevo.");
            }
        }

    }


    public void registrarProducto() {
        List <Producto> ListaTemporal = new ArrayList<>();
        boolean AgregarMas;
        do {
        try {
            String codigo = vista.pedirDato("Ingrese el código del producto:");
            if (codigo == null) break; 

            String nombre = vista.pedirDato("Ingrese el nombre del producto:");
            if (nombre == null) break;

            String precioTexto = vista.pedirDato("Ingrese el precio del producto:");
            if (precioTexto == null) break;

            double precio = Double.parseDouble(precioTexto);

            Producto producto = new Producto(codigo, nombre, precio);

            loader.guardar(producto);

            ListaTemporal.add(producto);
        
            vista.mostrarMensaje("¡Producto guardado exitosamente!");

            AgregarMas = vista.confirmar("¿Desea agregar otro producto?");

        } catch (NumberFormatException e) {
            vista.mostrarError("El precio ingresado no es un número válido.");
        } catch (IllegalArgumentException e) {
            vista.mostrarError("Error en los datos: " + e.getMessage());
        } catch (IOException e) {
            vista.mostrarError("Error al guardar en el archivo: " + e.getMessage());
        }

    } while (AgregarMas);
    if (!ListaTemporal.isEmpty()) {
    vista.mostrarMensaje("Se guardaron " + ListaTemporal.size() + " producto(s) en esta sesión.");
    }
}

    public void verProductos() {
        try {
            String contenido = loader.leerTodo();
            if (contenido.isBlank()) {
                vista.mostrarMensaje("No hay productos registrados.");
            } else {
                vista.mostrarMensaje("Productos registrados:\n" + contenido);
            }
        } catch (IOException e) {
            vista.mostrarError("Error al leer el archivo: " + e.getMessage());
        }
    }
}