package DLL;

import javax.swing.JOptionPane;

import BLL.Producto;

import java.util.LinkedList;

public class GestionProductos {
    private LinkedList<Producto> productos;

    public GestionProductos() {
        this.productos = new LinkedList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void mostrarProductos() {
        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos disponibles", "Lista de Productos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder productosStr = new StringBuilder();
        productosStr.append("ID\tNombre\tDescripción\tPrecio\tStock\n");

        for (Producto producto : productos) {
            productosStr.append(producto.getIdProducto())
                         .append("\t")
                         .append(producto.getNombre())
                         .append("\t")
                         .append(producto.getDescripcion())
                         .append("\t")
                         .append(producto.getPrecio())
                         .append("\t")
                         .append(producto.getStock())
                         .append("\n");
        }

        JOptionPane.showMessageDialog(null, productosStr.toString(), "Lista de Productos", JOptionPane.INFORMATION_MESSAGE);
    }

    public LinkedList<Producto> getProductos() {
        return productos;
    }
}
