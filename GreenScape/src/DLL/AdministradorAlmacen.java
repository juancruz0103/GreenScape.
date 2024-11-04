package DLL;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import BLL.Administrador;
import BLL.Compra;
import BLL.Producto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class AdministradorAlmacen extends Administrador {
	
    private LinkedList<Producto> productosGestionados;
    
    private LinkedList<Compra> comprasRealizadas;
    
    private static Connection con = Conexion.getInstance().getConnection();  

    public AdministradorAlmacen(String nombre, int idAdmin, String email, LinkedList<Producto> productosGestionados, LinkedList<Compra> comprasRealizadas) {
        super(nombre, idAdmin, email);
        this.productosGestionados = productosGestionados;
        this.comprasRealizadas = comprasRealizadas;
    }

    public static void crearProducto(Producto producto) {
        try {
            PreparedStatement statement = (PreparedStatement) con.prepareStatement(
                    "INSERT INTO `producto` (`nombre`, `descripcion`, `stock`, `precio`) VALUES (?,?,?,?)"
            );
            statement.setString(1, producto.getNombre());
            statement.setString(2, producto.getDescripcion());
            statement.setInt(3, producto.getStock());
            statement.setDouble(4, producto.getPrecio());

            int fila = statement.executeUpdate();

            if (fila > 0) {
                JOptionPane.showMessageDialog(null, "Producto guardado con éxito.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el producto: " + e.getMessage());
        }
    }

    public static LinkedList<Producto> mostrarProducto() {
        LinkedList<Producto> productos = new LinkedList<>();
        try {
            PreparedStatement statement = (PreparedStatement) con.prepareStatement("SELECT * FROM `producto`");
            ResultSet resultados = statement.executeQuery();

            while (resultados.next()) {
                productos.add(new Producto(
                        resultados.getInt("idproducto"),

                        resultados.getString("nombre"),
                        resultados.getString("descripcion"),
                        resultados.getInt("stock"),
                        resultados.getDouble("precio")
                ));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar productos: " + e.getMessage());
        }

        return productos;
    }


    public static Boolean actualizarProducto(Producto producto) {
        try {
            PreparedStatement statement = (PreparedStatement) con.prepareStatement(
                    "UPDATE `producto` SET `nombre` = ?, `descripcion` = ?, `stock` = ?, `precio` = ? WHERE `idproducto` = ?"
            );
            statement.setString(1, producto.getNombre());
            statement.setString(2, producto.getDescripcion());
            statement.setInt(3, producto.getStock());
            statement.setDouble(4, producto.getPrecio());
            statement.setInt(5, producto.getIdProducto());

            int fila = statement.executeUpdate();

            if (fila > 0) {
                JOptionPane.showMessageDialog(null, "Producto actualizado con éxito.");
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar producto: " + e.getMessage());
        }

        return false;
    }

    public static Boolean eliminarProducto(int idProducto) {
        try {
            PreparedStatement statement = (PreparedStatement) con.prepareStatement("DELETE FROM `producto` WHERE `idproducto` = ?");
            statement.setInt(1, idProducto);

            int fila = statement.executeUpdate();

            if (fila > 0) {
                JOptionPane.showMessageDialog(null, "Producto eliminado con éxito.");
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar producto: " + e.getMessage());
        }

        return false;
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


















