public class Carro {
    private String marca;
    private double precio;

    public Carro(String marca, double precio) {
        this.marca = marca;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + " | Precio: $" + precio;
    }
}