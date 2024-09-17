
public class Producto {
    private String nombre;
    private int idProducto;
    private String descripcion;
    private double precio;
    private int stock;

    public Producto(String nombre, int idProducto, String descripcion, double precio, int stock) {
        this.nombre = nombre;
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    public void actualizarProducto(String descripcion, double precio, int stock) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
