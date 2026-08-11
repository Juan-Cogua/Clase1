package Ejecicio;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in);
            Writer escritor = new FileWriter("productos.txt", true)) {

                    System.out.println("\nDatos del Producto");

                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Cantidad: ");
                    String cantidad = scanner.nextLine();

                    System.out.print("Precio: ");
                    String precio = scanner.nextLine();

                    scanner.nextLine();

                    String Registro = nombre + ";" + cantidad + ";" + precio;

                    escritor.write(Registro);
                    escritor.write(System.lineSeparator());

            System.out.println("Producto guardado");

        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }
}