package Ejecicio;

public class Main {
    public static void main(String[] args) {
        ProductoVista vista = new ProductoVista();
        ProductoLoader loader = new ProductoLoader("productos.txt");
        ProductoController controller = new ProductoController(vista, loader);

        controller.registrarProducto();
    }
}