package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import BLL.Producto;
import BLL.Usuario;
import DLL.AdministradorAlmacen;

public class PantallaProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Usuario usuarioLogueado;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public PantallaProducto() {
		Usuario usuarioLogueado = null;
		this.usuarioLogueado = usuarioLogueado;

        setTitle("Gestión de Tienda");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Título
        JLabel titleLabel = new JLabel("Bienvenido a la tienda, " + usuarioLogueado.getNombre(), JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Área de texto para mostrar productos
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 1, 10, 10));

        JButton btnVerProductos;
		JButton btnSalir;
		// Botones según el rol
        if (usuarioLogueado.getRol().equalsIgnoreCase("usuario")) {
            btnVerProductos = new JButton("Ver productos");
            Component btnComprarProductos = new JButton("Comprar productos");
            btnSalir = new JButton("Salir");

            buttonPanel.add(btnVerProductos);
            buttonPanel.add(btnComprarProductos);
            buttonPanel.add(btnSalir);

            // Acción de ver productos
            btnVerProductos.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mostrarProductos();
                }
            });

            // Acción de salir
            btnSalir.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

        } else if (usuarioLogueado.getRol().equalsIgnoreCase("almacenero")) {
            btnVerProductos = new JButton("Ver productos");
            JButton btnAgregarProducto = new JButton("Agregar producto");
            JButton btnActualizarProducto = new JButton("Actualizar producto");
            Object btnEliminarProducto = new JButton("Eliminar producto");
            btnSalir = new JButton("Salir");

            buttonPanel.add(btnVerProductos);
            buttonPanel.add(btnAgregarProducto);
            buttonPanel.add(btnActualizarProducto);
            buttonPanel.add((Component) btnEliminarProducto);
            buttonPanel.add(btnSalir);

            // Acción de ver productos
            btnVerProductos.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mostrarProductos();
                }
            });

            // Acción de agregar producto
            btnAgregarProducto.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    agregarProducto();
                }
            });

            // Acción de actualizar producto
            btnActualizarProducto.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    actualizarProducto();
                }
            });

            // Acción de eliminar producto
            ((AbstractButton) btnEliminarProducto).addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    eliminarProducto();
                }
            });

            // Acción de salir
            btnSalir.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
        } else {
            JOptionPane.showMessageDialog(this, "Rol no autorizado para gestionar la tienda.");
            System.exit(0);
        }

        // Añadir componentes al frame
        add(titleLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.EAST);
    }

    // Método para mostrar productos
    private void mostrarProductos() {
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
        AbstractButton textArea = null;
		textArea.setText(listaProductos.toString());
    }

    // Método para agregar producto (aquí deberías implementar la lógica de entrada de producto)
    private void agregarProducto() {
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del producto:");
        String descripcion = JOptionPane.showInputDialog(this, "Ingrese la descripción del producto:");
        int stock = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el stock del producto:"));
        double precio = Double.parseDouble(JOptionPane.showInputDialog(this, "Ingrese el precio del producto:"));

        Producto nuevoProducto = new Producto(nombre, descripcion, stock, precio);
        AdministradorAlmacen.actualizarProducto(nuevoProducto);
        JOptionPane.showMessageDialog(this, "Producto agregado con éxito.");
    }

    // Método para actualizar producto (simulado por ahora)
    private void actualizarProducto() {
        String idProducto = JOptionPane.showInputDialog(this, "Ingrese el ID del producto a actualizar:");
        // Implementar la lógica de actualización de producto
        JOptionPane.showMessageDialog(this, "Producto actualizado con éxito.");
    }

    // Método para eliminar producto (simulado por ahora)
    private void eliminarProducto() {
        String idProducto = JOptionPane.showInputDialog(this, "Ingrese el ID del producto a eliminar:");
        // Implementar la lógica de eliminación de producto
        JOptionPane.showMessageDialog(this, "Producto eliminado con éxito.");
    }


		
		
	}


