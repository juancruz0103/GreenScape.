import java.util.LinkedList;

public class AdministradorAlmacen extends Administrador {
    private LinkedList<Producto> productosGestionados;
    private LinkedList<Compra> comprasRealizadas;

    public AdministradorAlmacen(String nombre, int idAdmin, String email, LinkedList<Producto> productosGestionados, LinkedList<Compra> comprasRealizadas) {
        super(nombre, idAdmin, email);
        this.productosGestionados = productosGestionados;
        this.comprasRealizadas = comprasRealizadas;
    }
    
    // Para añadir con la base de datos: Logica para gestionar productos

    public void gestionarProductos() {
        
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
