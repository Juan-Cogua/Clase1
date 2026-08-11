import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        ArrayList<Persona> personas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\nMENÚ PRINCIPAL");
            System.out.println("1. Agregar persona con carro");
            System.out.println("2. Mostrar todas las personas con su carro");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\nDatos de la Persona");
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("\nDatos del Carro");
                    System.out.print("Marca del carro: ");
                    String marca = scanner.nextLine();

                    System.out.print("Precio del carro: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine();

                    Carro carro = new Carro(marca, precio);
                    Persona persona = new Persona(nombre, edad, carro);
                    personas.add(persona);

                    System.out.println("\n¡Registrados exitosamente!");
                    break;

                case 2:
                    System.out.println("\nLISTA DE PERSONAS Y CARROS");
                    if (personas.isEmpty()) {
                        System.out.println("No hay registros disponibles.");
                    } else {
                        for (int i = 0; i < personas.size(); i++) {
                            System.out.println((i + 1) + ". " + personas.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 3);

        scanner.close();
    }
}