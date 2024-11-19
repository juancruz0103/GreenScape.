package GUI;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import BLL.Usuario;

public class PantallaRegistro extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField inpNombre;
    private JTextField inpCorreo;
    private JPasswordField pswContrania;
    private JTextField inpIdUsuario;  // Campo para ingresar el idUsuario
    private JLabel lblError;

    // Definir el ComboBox para los roles
    private JComboBox<String> comboRoles;

    public PantallaRegistro() {
        setTitle("Registro de Usuario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 400);  // Ajusta el tamaño de la ventana para que quepan todos los campos
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Registro de Usuario");
        lblTitulo.setFont(new Font("juan", Font.BOLD, 18));
        lblTitulo.setBounds(140, 20, 200, 30);
        contentPane.add(lblTitulo);

        // Campo para el ID de usuario
        JLabel lblIdUsuario = new JLabel("ID Usuario:");
        lblIdUsuario.setBounds(30, 70, 100, 20);
        contentPane.add(lblIdUsuario);

        inpIdUsuario = new JTextField();
        inpIdUsuario.setBounds(140, 70, 200, 20);
        contentPane.add(inpIdUsuario);
        inpIdUsuario.setColumns(10);

        // Campo para el nombre de usuario
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 110, 100, 20);
        contentPane.add(lblNombre);

        inpNombre = new JTextField();
        inpNombre.setBounds(140, 110, 200, 20);
        contentPane.add(inpNombre);
        inpNombre.setColumns(10);

        // Campo para el correo electrónico
        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setBounds(30, 150, 100, 20);
        contentPane.add(lblCorreo);

        inpCorreo = new JTextField();
        inpCorreo.setBounds(140, 150, 200, 20);
        contentPane.add(inpCorreo);
        inpCorreo.setColumns(10);

        // Campo para la contraseña
        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(30, 190, 100, 20);
        contentPane.add(lblContrasena);

        pswContrania = new JPasswordField();
        pswContrania.setBounds(140, 190, 200, 20);
        contentPane.add(pswContrania);

        // Selección de rol
        JLabel lblRol = new JLabel("Rol:");
        lblRol.setBounds(30, 230, 100, 20);
        contentPane.add(lblRol);

        // ComboBox para seleccionar el rol
        comboRoles = new JComboBox<>();
        comboRoles.addItem("usuario"); 
        comboRoles.addItem("jardinero");
        comboRoles.addItem("almacenero");
        comboRoles.setBounds(140, 230, 200, 20);
        contentPane.add(comboRoles);

        // Mensaje de error
        lblError = new JLabel("");
        lblError.setForeground(Color.RED);
        lblError.setBounds(140, 260, 200, 20);
        contentPane.add(lblError);

        // Botón de registro
        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(140, 290, 100, 30);
        contentPane.add(btnRegistrar);

        // Botón de regresar
        JButton btnAtras = new JButton("Atrás");
        btnAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Pantallalogin nuevo = new Pantallalogin();
                nuevo.setVisible(true);
                dispose();
            }
        });
        btnAtras.setBounds(30, 290, 89, 23);
        contentPane.add(btnAtras);

        // Acción del botón de registro
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idUsuarioStr = inpIdUsuario.getText().trim();
                String nombre = inpNombre.getText().trim();
                String correo = inpCorreo.getText().trim();
                String contrasena = new String(pswContrania.getPassword()).trim();
                String rol = comboRoles.getSelectedItem().toString();  // Obtener el rol seleccionado

                // Validación de los campos
                if (idUsuarioStr.isEmpty() || nombre.isEmpty() || correo.isEmpty() || contrasena.isEmpty()) {
                    lblError.setText("Todos los campos son requeridos.");
                } else {
                    try {
                        // Convertir el idUsuario a un número entero
                        Integer idUsuario = Integer.parseInt(idUsuarioStr);

                        // Registrar al usuario llamando al método save de Usuario
                        boolean registroExitoso = Usuario.save(nombre, idUsuario, correo, contrasena, rol);

                        if (registroExitoso) {
                            JOptionPane.showMessageDialog(null, "Registro exitoso.");
                            dispose(); // Cerrar la ventana actual si el registro es exitoso
                        } else {
                            lblError.setText("Error al registrar el usuario.");
                        }
                    } catch (NumberFormatException ex) {
                        lblError.setText("El ID de usuario debe ser un número válido.");
                    }
                }
            }
        });
    }
}



