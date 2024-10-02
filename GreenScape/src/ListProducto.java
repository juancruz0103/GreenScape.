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
		//productos.add(new Producto("Rosa Roja", "Flor roja ornamental.", 30,310.00));
	}
}
 