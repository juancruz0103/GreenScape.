package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import BLL.Usuario;
import DLL.AdministradorJardinero;
import BLL.Administrador;
import java.util.List;

public class Pantallalogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField inpMail;
    private JPasswordField inpcontra;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Pantallalogin frame = new Pantallalogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Pantallalogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel imglogo = new JLabel("New label");
        imglogo.setIcon(new ImageIcon("C:/Users/Alumno/Documents/GitHub/GreenScape2/GreenScape/src/img/plantalogo.jpg"));
        imglogo.setBounds(224, 58, 200, 150);
        contentPane.add(imglogo);
        
        JLabel lblMail = new JLabel("Mail");
        lblMail.setBounds(31, 46, 98, 20);
        contentPane.add(lblMail);
        
        JLabel lbltitulo = new JLabel("GreenScape");
        lbltitulo.setForeground(new Color(34, 139, 34));
        lbltitulo.setBounds(181, 11, 86, 36);
        contentPane.add(lbltitulo);
        
        inpMail = new JTextField();
        inpMail.setBounds(31, 77, 125, 20);
        contentPane.add(inpMail);
        inpMail.setColumns(10);
        
        JLabel lblcontrasena = new JLabel("Contraseña");
        lblcontrasena.setBounds(31, 121, 86, 14);
        contentPane.add(lblcontrasena);
        
        JLabel lblerror = new JLabel("");
        lblerror.setForeground(Color.RED);
        lblerror.setBounds(31, 177, 169, 20);
        contentPane.add(lblerror);

        // Botón para registrarse
        JButton btnRegistrarse = new JButton("Registrarse");
        btnRegistrarse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PantallaRegistro nuevo = new PantallaRegistro();
                nuevo.setVisible(true);
                dispose();
            }
        });
        btnRegistrarse.setBounds(250, 209, 89, 23);
        contentPane.add(btnRegistrarse);

        // Botón de "Enviar" para iniciar sesión
        JButton btnEnviar = new JButton("Enviar");
        btnEnviar.addActionListener(new ActionListener() {
            private List<Usuario> usuario;
            public void actionPerformed(ActionEvent e) {
                Usuario usuarioLogueado = Usuario.login(inpMail.getText(), inpcontra.getText());

                if (usuarioLogueado != null) {
                    JOptionPane.showMessageDialog(null, "Login exitoso. Bienvenido " + usuarioLogueado.getNombre());

                    if (usuarioLogueado.getRol().equalsIgnoreCase("usuario")) {
                        // Si es usuario, redirigir a la pantalla de productos
                        PantallaMenu pantallaUsuario = new PantallaMenu(usuarioLogueado);
                        pantallaUsuario.setVisible(true);
                        dispose();
                    } else if (usuarioLogueado.getRol().equalsIgnoreCase("almacenero")) {
                        // Si es almacenero, redirigir a la pantalla de gestión de productos
                        PantallaAlmacenero pantallaAlmacenero = new PantallaAlmacenero(usuarioLogueado); 
                        pantallaAlmacenero.setVisible(true);
                        dispose();
                    } else if (usuarioLogueado.getRol().equalsIgnoreCase("jardinero")) {
                        // Si es Jardinero, redirigir a la pantalla de gestión de cursos
                        PantallaJardinero pantallaJardinero = new PantallaJardinero(usuarioLogueado);
                        pantallaJardinero.setVisible(true);
                        dispose();

                    } else {
                        JOptionPane.showMessageDialog(null, "Rol no reconocido.");
                    }

                    // Cerrar la pantalla de login
                    dispose();
                } else {
                    lblerror.setText("Credenciales incorrectas. Intente de nuevo.");
                }
            }
        });
        btnEnviar.setBounds(31, 209, 89, 23);
        contentPane.add(btnEnviar);

        // Campo de contraseña
        inpcontra = new JPasswordField();
        inpcontra.setBounds(31, 146, 125, 20);
        contentPane.add(inpcontra);
    }
}



//login de prueba

//Usuario
//Pepe@gmail.com      Pepespass1


//Almacenero
//Juan@gmail.com      Juanpass1

//Jardinero
//Lucas@gmail.com     Lucasspass1




