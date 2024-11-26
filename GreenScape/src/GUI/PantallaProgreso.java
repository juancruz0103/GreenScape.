package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import BLL.Curso;
import BLL.Usuario;
import DLL.AdministradorJardinero;

public class PantallaProgreso extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tableCursos;
    private JScrollPane scrollPane;
    private JButton btnMostrarCursos;
    private DefaultTableModel tableModel;
    private Usuario usuarioLogueado; 
    private final JButton btnSalir = new JButton("Atras");

    public PantallaProgreso(Usuario usuario) {
    	this.usuarioLogueado = usuario;
        setTitle("Gestión de Cursos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 592, 575);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Título de la ventana
        JLabel lblTitulo = new JLabel("Cursos Registrados");
        lblTitulo.setBounds(0, 0, 576, 19);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblTitulo);

        // Crear tabla con un modelo de datos vacío
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID Curso");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Descripción");

        tableCursos = new JTable(tableModel);
        tableCursos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Permitir solo una selección a la vez

        // Scroll pane para la tabla
        scrollPane = new JScrollPane(tableCursos);
        scrollPane.setBounds(0, 19, 576, 427);
        contentPane.add(scrollPane);

        // Botón para mostrar los cursos
        btnMostrarCursos = new JButton("Mostrar Cursos");
        btnMostrarCursos.setBounds(0, 446, 576, 23);
        btnMostrarCursos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarCursos();
            }
        });
        
        contentPane.add(btnMostrarCursos);
        
        // Botón de salir (regresar al menú anterior)
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PantallaMenu nuevo = new PantallaMenu(usuario);
                nuevo.setVisible(true);
                dispose();
            }
        });
        btnSalir.setBounds(230, 480, 120, 31);
        contentPane.add(btnSalir);
    }

    // Método para mostrar los cursos en la tabla
    public void mostrarCursos() {
        LinkedList<Curso> cursos = AdministradorJardinero.mostrarCursos(); 

        if (cursos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay cursos registrados.");
            return;
        }

        // Limpiar la tabla antes de agregar los nuevos cursos
        tableModel.setRowCount(0);

        // Agregar los cursos a la tabla
        for (Curso curso : cursos) {
            Object[] row = new Object[3];
            row[0] = curso.getIdCurso();       
            row[1] = curso.getNombre();        
            row[2] = curso.getinformacion();   

            tableModel.addRow(row); 
        }
    }
}
