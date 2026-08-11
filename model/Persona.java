public class Persona {
    private String nombre;
    private int edad;
    private Carro carro;

    public Persona(String nombre, int edad, Carro carro) {
        this.nombre = nombre;
        this.edad = edad;
        this.carro = carro;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public Carro getCarro() {
        return carro;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Edad: " + edad + " | Carro: [" + carro + "]";
    }
}