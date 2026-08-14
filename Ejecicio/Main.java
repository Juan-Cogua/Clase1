package Ejecicio;

import Ejecicio.Cotroller.ProductoController;
import Ejecicio.Loader.ProductoLoader;
import Ejecicio.Vista.ProductoVista;

public class Main {
    public static void main(String[] args) {
        ProductoVista vista = new ProductoVista();
        ProductoLoader loader = new ProductoLoader("productos.txt");
        ProductoController controller = new ProductoController(vista, loader);

        controller.iniciar();
    }
}