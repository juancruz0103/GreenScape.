package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Producto;
import BLL.Usuario;
import DLL.AdministradorAlmacen;

import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;
	import java.util.LinkedList;

	public class PantallaTiendaUsuario extends JFrame {

	    private JPanel contentPane;
	    private JList<String> productosList;
	    private DefaultListModel<String> listModel;
	    private Usuario usuarioLogueado; // Usuario logueado

	    public PantallaTiendaUsuario(Usuario usuario) {
	        this.usuarioLogueado = usuario;

	        setTitle("Tienda - Usuario");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 450, 300);
	        contentPane = new JPanel();
	        contentPane.setLayout(new BorderLayout());
	        setContentPane(contentPane);

	        // Título en la parte superior
	        JLabel lblBienvenido = new JLabel("Bienvenido, " + usuarioLogueado.getNombre(), SwingConstants.CENTER);
	        contentPane.add(lblBienvenido, BorderLayout.NORTH);

	        // Modelo para la lista de productos
	        listModel = new DefaultListModel<>();
	        productosList = new JList<>(listModel);
	        JScrollPane scrollPane = new JScrollPane(productosList);
	        contentPane.add(scrollPane, BorderLayout.CENTER);

	        // Botones
	        JPanel panelBotones = new JPanel();
	        contentPane.add(panelBotones, BorderLayout.SOUTH);

	        JButton btnVerProductos = new JButton("Ver productos");
	        panelBotones.add(btnVerProductos);

	        JButton btnComprar = new JButton("Comprar productos");
	        panelBotones.add(btnComprar);

	        JButton btnSalir = new JButton("Salir");
	        panelBotones.add(btnSalir);

	        // ActionListener para "Ver productos"
	        btnVerProductos.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                mostrarProductos();
	            }
	        });

	        // ActionListener para "Comprar productos"
	        btnComprar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                realizarCompra();
	            }
	        });

	        // ActionListener para "Salir"
	        btnSalir.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
					
					PantallaMenu nuevo = new PantallaMenu();
					nuevo.setVisible(true);
					dispose();
				}
	        });
	    }

	    // Mostrar los productos disponibles
	    private void mostrarProductos() {
	        LinkedList<Producto> productos = AdministradorAlmacen.mostrarProducto();
	        listModel.clear(); // Limpiar la lista antes de mostrar los productos

	        for (Producto producto : productos) {
	            listModel.addElement("ID: " + producto.getIdProducto() + " - " + producto.getNombre() + " ($" + producto.getPrecio() + ")");
	        }
	    }

	    // Permitir al usuario comprar un producto
	    private void realizarCompra() {
	        int selectedIndex = productosList.getSelectedIndex();
	        if (selectedIndex != -1) {
	            // Obtener el producto seleccionado
	            LinkedList<Producto> productos = AdministradorAlmacen.mostrarProducto();
	            Producto productoSeleccionado = productos.get(selectedIndex);

	            // Preguntar por la cantidad
	            String cantidadStr = JOptionPane.showInputDialog("Ingrese la cantidad que desea comprar:");
	            if (cantidadStr == null || cantidadStr.trim().isEmpty()) return;

	            try {
	                int cantidad = Integer.parseInt(cantidadStr);
	                if (cantidad > productoSeleccionado.getStock()) {
	                    JOptionPane.showMessageDialog(this, "No hay suficiente stock disponible.");
	                } else {
	                    double total = productoSeleccionado.getPrecio() * cantidad;
	                    JOptionPane.showMessageDialog(this, "Compra realizada exitosamente. Total: $" + total);
	                }
	            } catch (NumberFormatException e) {
	                JOptionPane.showMessageDialog(this, "Cantidad no válida.");
	            }
	        } else {
	            JOptionPane.showMessageDialog(this, "Seleccione un producto para comprar.");
	        }
	    }

	    
	}



