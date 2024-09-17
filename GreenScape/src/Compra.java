import java.util.LinkedList;
import java.util.Date;

public class Compra {
    private int idCompra;
    private int idUsuario;
    private LinkedList<Producto> productos;
    private Date fecha;
    private double total;

    public Compra(int idCompra, int idUsuario, LinkedList<Producto> productos, Date fecha, double total) {
        this.idCompra = idCompra;
        this.idUsuario = idUsuario;
        this.productos = productos;
        this.fecha = fecha;
        this.total = total;
    }
    
    // Para añadir con la base de datos: Lógica para realizar compra, para consultar compra.

    public void realizarCompra() {
       
    }

    public void consultarCompra() {
      
    }

   
    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LinkedList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(LinkedList<Producto> productos) {
        this.productos = productos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
