package Ejecicio.Loader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import Ejecicio.model.Producto;



public class ProductoLoader {
    private final String rutaArchivo;

    public ProductoLoader(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public void guardar(Producto producto) throws IOException {
        try (Writer escritor = new FileWriter(rutaArchivo, true)) {
            escritor.write(producto.aTexto());
            escritor.write(System.lineSeparator());
        }
    }
}