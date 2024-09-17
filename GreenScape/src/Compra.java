import java.util.Date;
import java.util.List;

public class Compra {
    private int idCompra;
    private int idUsuario;
    private List<Producto> productos;
    private Date fecha;
    private double total;

    public Compra(int idCompra, int idUsuario, List<Producto> productos, Date fecha, double total) {
        this.idCompra = idCompra;
        this.idUsuario = idUsuario;
        this.productos = productos;
        this.fecha = fecha;
        this.total = total;
    }
    
   // Para añadir con la base de datos: Logica para realizar compras, consultar compras.

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

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
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
