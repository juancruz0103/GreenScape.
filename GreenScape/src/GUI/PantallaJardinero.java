package GUI;

import javax.swing.*;
import DLL.AdministradorJardinero; 
import BLL.Curso;
import BLL.Usuario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class PantallaJardinero extends JFrame {

    private Usuario jardineroLogueado;  

    // Constructor que recibe un AdministradorJardinero
    public PantallaJardinero(Usuario usuarioLogueado) {
        this.jardineroLogueado = usuarioLogueado;

        setTitle("Gestión de Cursos - Jardinero");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Etiqueta de bienvenida
        JLabel lblTitulo = new JLabel("Bienvenido, " + usuarioLogueado.getNombre());
        lblTitulo.setBounds(150, 20, 200, 30);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        contentPane.add(lblTitulo);

        // Crear botones para las acciones
        JButton btnVerCursos = new JButton("Ver Cursos");
        btnVerCursos.setBounds(180, 60, 140, 30);
        contentPane.add(btnVerCursos);

        JButton btnCrearCurso = new JButton("Crear Curso");
        btnCrearCurso.setBounds(180, 100, 140, 30);
        contentPane.add(btnCrearCurso);

        JButton btnActualizarCurso = new JButton("Actualizar Curso");
        btnActualizarCurso.setBounds(180, 140, 140, 30);
        contentPane.add(btnActualizarCurso);

        JButton btnEliminarCurso = new JButton("Eliminar Curso");
        btnEliminarCurso.setBounds(180, 180, 140, 30);
        contentPane.add(btnEliminarCurso);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(180, 220, 140, 30);
        contentPane.add(btnSalir);

        // Agregar los escuchadores de eventos para cada botón según la funcionalidad
        btnVerCursos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ver cursos
                LinkedList<Curso> cursos = AdministradorJardinero.mostrarCursos();
                StringBuilder listaCursos = new StringBuilder();
                
                if (cursos.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No hay cursos disponibles.");
                    return;
                }
                
                for (Curso curso : cursos) {
                    listaCursos.append("ID del Curso: ").append(curso.getIdCurso())
                    .append(", Nombre: ").append(curso.getNombre())
                    .append(", Descripción: ").append(curso.getinformacion())
                    .append("\n");
                }
                
                JOptionPane.showMessageDialog(null, listaCursos.toString(), "Lista de Cursos", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnCrearCurso.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Crear nuevo curso
                String nombreCurso = JOptionPane.showInputDialog("Ingrese el nombre del curso:");
                
                if (nombreCurso == null || nombreCurso.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "El nombre del curso no puede estar vacío.");
                    return;
                }

                String descripcion = JOptionPane.showInputDialog("Ingrese la descripción del curso:");
                
                if (descripcion == null || descripcion.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "La descripción no puede estar vacía.");
                    return;
                }

                Curso nuevoCurso = new Curso(nombreCurso, descripcion);
                boolean exito = AdministradorJardinero.crearCurso(nuevoCurso);
                
                if (exito) {
                    JOptionPane.showMessageDialog(null, "Curso creado exitosamente.");
                }
            }
        });

        btnActualizarCurso.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Actualizar curso
                String idCursoStr = JOptionPane.showInputDialog("Ingrese el ID del curso a actualizar:");
                
                if (idCursoStr == null || idCursoStr.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "El ID del curso no puede estar vacío.");
                    return;
                }

                int idCurso = Integer.parseInt(idCursoStr);
                
                String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del curso:");
                
                if (nuevoNombre == null || nuevoNombre.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.");
                    return;
                }

                String nuevaDescripcion = JOptionPane.showInputDialog("Ingrese la nueva descripción del curso:");
                
                if (nuevaDescripcion == null || nuevaDescripcion.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "La descripción no puede estar vacía.");
                    return;
                }

                Curso cursoActualizado = new Curso(idCurso, nuevoNombre, nuevaDescripcion);
                boolean exito = AdministradorJardinero.actualizarCurso(cursoActualizado);

                if (exito) {
                    JOptionPane.showMessageDialog(null, "Curso actualizado exitosamente.");
                }
            }
        });

        btnEliminarCurso.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Eliminar curso
                String idCursoStr = JOptionPane.showInputDialog("Ingrese el ID del curso a eliminar:");
                
                if (idCursoStr == null || idCursoStr.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "El ID del curso no puede estar vacío.");
                    return;
                }

                int idCurso = Integer.parseInt(idCursoStr);
                boolean exito = AdministradorJardinero.eliminarCurso(idCurso);

                if (exito) {
                    JOptionPane.showMessageDialog(null, "Curso eliminado exitosamente.");
                }
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Salir de la pantalla
                dispose();
            }
        });
    }
}
