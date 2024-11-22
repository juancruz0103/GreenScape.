package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import BLL.Proyecto;
import DLL.Listproyectos;

public class PantallaCurso extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tableProyectos;
    private JScrollPane scrollPane;
    private JButton btnMostrarProyectos;
    private DefaultTableModel tableModel;
    private final JButton btnSalir = new JButton("Atras");



    public PantallaCurso() {
        setTitle("Gestión de Proyectos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 592, 575);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Título de la ventana
        JLabel lblTitulo = new JLabel("Proyectos Registrados");
        lblTitulo.setBounds(0, 0, 576, 19);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblTitulo);

        // Crear tabla con un modelo de datos vacío
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID Proyecto");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Fecha de Inicio");
        tableModel.addColumn("Estado");

        tableProyectos = new JTable(tableModel);
        tableProyectos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Permitir solo una selección a la vez

        // Scroll pane para la tabla
        scrollPane = new JScrollPane(tableProyectos);
        scrollPane.setBounds(0, 19, 576, 427);
        contentPane.add(scrollPane);

        // Botón para mostrar los proyectos
        btnMostrarProyectos = new JButton("Mostrar Proyectos");
        btnMostrarProyectos.setBounds(0, 446, 576, 23);
        btnMostrarProyectos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarProyectos();
            }
        });
        
        contentPane.add(btnMostrarProyectos);
        
        btnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				
				PantallaMenu nuevo = new PantallaMenu(null);
				nuevo.setVisible(true);
				dispose();
			}
        });
        btnSalir.setBounds(230, 480, 120, 31);
        contentPane.add(btnSalir);
    }

    // Método para mostrar los proyectos en la tabla
    public void mostrarProyectos() {
        LinkedList<Proyecto> proyectos = Listproyectos.getInstance();  // Obtener los proyectos

        if (proyectos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay proyectos registrados.");
            return;
        }

        // Limpiar la tabla antes de agregar los nuevos proyectos
        tableModel.setRowCount(0);

        // Agregar los proyectos a la tabla
        for (Proyecto proyecto : proyectos) {
            Object[] row = new Object[4];
            row[0] = proyecto.getIdProyecto();      // ID
            row[1] = proyecto.getNombre();         // Nombre
            row[2] = proyecto.getFechaInicio();    // Fecha de Inicio
            row[3] = proyecto.getEstado();         // Estado

            tableModel.addRow(row);  // Agregar fila a la tabla
        }
    }
}
