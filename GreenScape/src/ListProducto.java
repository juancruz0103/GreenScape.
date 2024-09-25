import java.util.LinkedList; 
import javax.swing.*;

public class ListProducto {
	private static LinkedList<Producto> productos;
	private static String deposito;
	
	public ListProducto() {
		
	}
	
	public static LinkedList<Producto> getInstance(String deposito){
		if (productos==null) {
			productos = new LinkedList<Producto>();
			deposito = deposito;
			rellenarLista();
		} else {
			JOptionPane.showMessageDialog(null, "Ya existe");
		}
		return productos;
	}
	
	public static void guardar(Producto Producto) {
		productos.add(Producto);
	}
	
	
	public static void rellenarLista(){
		productos.add(new Producto("Rosa Roja", 101, "Flor roja ornamental.", 310.00, 30));
		productos.add(new Producto("Helecho", 102, "Planta de interior.", 200.00, 20));
		productos.add(new Producto("Cactus Saguaro", 103, "Cactus resistente.", 450.00, 15));
		productos.add(new Producto("Lavanda", 104, "Planta aromática.", 250.00, 25));
		productos.add(new Producto("Orquídea Phalaenopsis", 105, "Flor exótica de interior.", 600.00, 10));
		productos.add(new Producto("Aloe Vera", 106, "Planta medicinal.", 170.00, 40));
		productos.add(new Producto("Bugambilias", 107, "Planta trepadora colorida.", 400.00, 12));
		productos.add(new Producto("Hoya", 108, "Enredadera fragante.", 360.00, 18));
		productos.add(new Producto("Pino enano", 109, "Pequeño árbol ornamental.", 540.00, 8));
		productos.add(new Producto("Geranio", 110, "Planta con flores coloridas.", 150.00, 35));
		
	}
}
 