package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import BLL.Producto;
import DLL.AdministradorAlmacen;
import BLL.Usuario;

public class PantallaAlmacenero extends JFrame {

    private JPanel contentPane;
    private JButton btnVerProductos;
    private JButton btnAgregarProducto;
    private JButton btnActualizarProducto;
    private JButton btnEliminarProducto;
    private JButton btnSalir;

    public PantallaAlmacenero(Usuario usuarioLogueado) {
        setTitle("Gestión de Tienda - Almacenero");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblTitulo = new JLabel("Bienvenido, " + usuarioLogueado.getNombre());
        lblTitulo.setBounds(150, 11, 200, 30);
        contentPane.add(lblTitulo);

        // Botón para ver productos
        btnVerProductos = new JButton("Ver Productos");
        btnVerProductos.setBounds(150, 60, 150, 30);
        contentPane.add(btnVerProductos);

        // Botón para agregar un nuevo producto
        btnAgregarProducto = new JButton("Agregar Producto");
        btnAgregarProducto.setBounds(150, 100, 150, 30);
        contentPane.add(btnAgregarProducto);

        // Botón para actualizar un producto
        btnActualizarProducto = new JButton("Actualizar Producto");
        btnActualizarProducto.setBounds(150, 140, 150, 30);
        contentPane.add(btnActualizarProducto);

        // Botón para eliminar un producto
        btnEliminarProducto = new JButton("Eliminar Producto");
        btnEliminarProducto.setBounds(150, 180, 150, 30);
        contentPane.add(btnEliminarProducto);

        // Botón para salir
        btnSalir = new JButton("Salir");
        btnSalir.setBounds(150, 220, 150, 30);
        contentPane.add(btnSalir);

        // Acción para el botón "Ver Productos"
        btnVerProductos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LinkedList<Producto> productos = AdministradorAlmacen.mostrarProducto();
                StringBuilder listaProductos = new StringBuilder();
                listaProductos.append("Productos disponibles:\n");

                for (Producto producto : productos) {
                    listaProductos.append("ID: ").append(producto.getIdProducto())
                            .append(": ").append(producto.getNombre())
                            .append(", Descripción: ").append(producto.getDescripcion())
                            .append(", Stock actual: ").append(producto.getStock())
                            .append(", Precio: $").append(producto.getPrecio())
                            .append("\n");
                }

                JOptionPane.showMessageDialog(null, listaProductos.toString());
            }
        });

        // Acción para el botón "Agregar Producto"
        btnAgregarProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
                if (nombreProducto == null || nombreProducto.trim().isEmpty()) return;

                String descripcion = JOptionPane.showInputDialog("Ingrese una descripción del producto:");
                if (descripcion == null || descripcion.trim().isEmpty()) return;

                String stockStr = JOptionPane.showInputDialog("Ingrese la cantidad en stock:");
                if (stockStr == null || stockStr.trim().isEmpty()) return;
                int stock = Integer.parseInt(stockStr);

                String precioStr = JOptionPane.showInputDialog("Ingrese el precio del producto:");
                if (precioStr == null || precioStr.trim().isEmpty()) return;
                double precio = Double.parseDouble(precioStr);

                Producto nuevoProducto = new Producto(nombreProducto, descripcion, stock, precio);
                AdministradorAlmacen.crearProducto(nuevoProducto);
            }
        });

        // Acción para el botón "Actualizar Producto"
        btnActualizarProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idProductoStr = JOptionPane.showInputDialog("Ingrese el ID del producto a actualizar:");
                if (idProductoStr == null || idProductoStr.trim().isEmpty()) return;
                int idProducto = Integer.parseInt(idProductoStr);

                String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre del producto:");
                if (nuevoNombre == null || nuevoNombre.trim().isEmpty()) return;

                String nuevaDescripcion = JOptionPane.showInputDialog("Nueva descripción del producto:");
                if (nuevaDescripcion == null || nuevaDescripcion.trim().isEmpty()) return;

                String nuevoStockStr = JOptionPane.showInputDialog("Nuevo stock del producto:");
                if (nuevoStockStr == null || nuevoStockStr.trim().isEmpty()) return;
                int nuevoStock = Integer.parseInt(nuevoStockStr);

                String nuevoPrecioStr = JOptionPane.showInputDialog("Nuevo precio del producto:");
                if (nuevoPrecioStr == null || nuevoPrecioStr.trim().isEmpty()) return;
                double nuevoPrecio = Double.parseDouble(nuevoPrecioStr);

                Producto productoActualizado = new Producto(idProducto, nuevoNombre, nuevaDescripcion, nuevoStock, nuevoPrecio);
                AdministradorAlmacen.actualizarProducto(productoActualizado);
            }
        });

        // Acción para el botón "Eliminar Producto"
        btnEliminarProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idProductoStr = JOptionPane.showInputDialog("Ingrese el ID del producto a eliminar:");
                if (idProductoStr == null || idProductoStr.trim().isEmpty()) return;
                int idProducto = Integer.parseInt(idProductoStr);
                AdministradorAlmacen.eliminarProducto(idProducto);
            }
        });

        // Acción para el botón "Salir"
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
