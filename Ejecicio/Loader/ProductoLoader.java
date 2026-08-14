package Ejecicio.Loader;

import Ejecicio.model.Producto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

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


    public String leerTodo() throws IOException {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            return "";
        }
        StringBuilder texto = new StringBuilder();
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                texto.append(linea).append(System.lineSeparator());
            }
        }
        return texto.toString();
    }

}