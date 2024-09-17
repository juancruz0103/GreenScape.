import java.util.List;

public class AdministradorAlmacen extends Administrador {
    private List<Producto> productosGestionados;
    private List<Compra> comprasRealizadas;

    public AdministradorAlmacen(String nombre, int idAdmin, String email, List<Producto> productosGestionados, List<Compra> comprasRealizadas) {
        super(nombre, idAdmin, email);
        this.productosGestionados = productosGestionados;
        this.comprasRealizadas = comprasRealizadas;
    }
    // Para añadir con la base de datos: Logica para gestionar los productos, Logica para comprobar compras

    public void gestionarProductos() {
        
    }

    public void comprobarCompras() {
        
    }
    public List<Producto> getProductosGestionados() {
        return productosGestionados;
    }

    public void setProductosGestionados(List<Producto> productosGestionados) {
        this.productosGestionados = productosGestionados;
    }

    public List<Compra> getComprasRealizadas() {
        return comprasRealizadas;
    }

    public void setComprasRealizadas(List<Compra> comprasRealizadas) {
        this.comprasRealizadas = comprasRealizadas;
    }
}
