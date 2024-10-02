import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class AdministradorAlmacen extends Administrador { 
    private LinkedList<Producto> productosGestionados;
    private LinkedList<Compra> comprasRealizadas;
    private static Connection con = Conexion.getInstance().getConnection();

    public AdministradorAlmacen(String nombre, int idAdmin, String email, LinkedList<Producto> productosGestionados, LinkedList<Compra> comprasRealizadas) {
        super(nombre, idAdmin, email);
        this.productosGestionados = productosGestionados;
        this.comprasRealizadas = comprasRealizadas;
     }
    
    // Para añadir con la base de datos: Logica para gestionar productos

    public static void crearProducto(Producto producto) {
    	
    	try {
			PreparedStatement statement = (PreparedStatement)
					con.prepareStatement("INSERT INTO `producto`(`nombre`, `descripcion`, `stock`, `precio`)"
									   + "VALUES (?,?,?,?)");
					statement.setString(1, producto.getNombre());
					statement.setString(2, producto.getDescripcion());
					statement.setInt(3, producto.getStock());
					statement.setDouble(4, producto.getPrecio());
					int fila = statement.executeUpdate();
					
					if (fila>0) {
						JOptionPane.showMessageDialog(null, "Se guardo con exito");
					}
		} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error");
		}
        
    }
    
    
    public static LinkedList<Producto> mostrarProducto() {
    	LinkedList<Producto> productos = new LinkedList<Producto>(); 
    	
    	try {
			PreparedStatement statement = (PreparedStatement)
					con.prepareStatement("SELECT * FROM `producto` ");
					ResultSet  resultados = statement.executeQuery();
					while (resultados.next()) {
						productos.add(new Producto(
								resultados.getString("nombre"),
								resultados.getString("descripcion"),
								resultados.getInt("stock"),
								resultados.getDouble("precio") 
								));
						
					}
		} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error");
		}
    	
    	return productos;
    }
    
    
    public static Boolean actualizarProducto(Usuario usuario) {    	
    	try {
			PreparedStatement statement = (PreparedStatement)
					con.prepareStatement("UPDATE...");
					ResultSet  resultados = statement.executeQuery();
		} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error");
		}
    	
    	return true;
    }
    

    public void comprobarCompras() {
      
    }

 
    public LinkedList<Producto> getProductosGestionados() {
        return productosGestionados;
    }

    public void setProductosGestionados(LinkedList<Producto> productosGestionados) {
        this.productosGestionados = productosGestionados;
    }

    public LinkedList<Compra> getComprasRealizadas() {
        return comprasRealizadas;
    }

    public void setComprasRealizadas(LinkedList<Compra> comprasRealizadas) {
        this.comprasRealizadas = comprasRealizadas;
    }
}
