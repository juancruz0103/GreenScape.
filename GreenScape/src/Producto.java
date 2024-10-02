
public class Producto {
    private int idProducto;
    private String nombre;
    private String descripcion;
    private int stock;
    private double precio;

    public Producto(int idProducto, String nombre, String descripcion, int stock, double precio) {
        this.nombre = nombre;
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
    }
    
    public Producto(String nombre, String descripcion, int stock, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
    }

    public void actualizarProducto(String descripcion, int stock, double precio) {
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
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

    // toString puesta
    
	@Override
	public String toString() {
		return "Planta=" + nombre + ", ID=" + idProducto + ", Descripcion=" + descripcion
				+ ", Precio=" + precio + ", Stock=" + stock + "\n";
	}
    
    
    
    
}

