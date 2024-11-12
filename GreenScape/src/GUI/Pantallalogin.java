package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Usuario;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

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
		
		JLabel imgmomo = new JLabel("New label");
		imgmomo.setIcon(new ImageIcon("C:\\Users\\Alumno\\Desktop\\GreenScape2-main\\GreenScape2\\GreenScape\\src\\img\\splinter.jpg"));
		imgmomo.setBounds(224, 58, 189, 141);
		contentPane.add(imgmomo);
		
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
		
		
		
		
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PantallaRegistro nuevo = new PantallaRegistro();
				nuevo.setVisible(true);
				dispose();
			}
		});
		
		btnRegistrarse.setBounds(250,209, 89, 23);
		contentPane.add(btnRegistrarse);
		
		
		
		
		
		
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			
			private List<Usuario> usuarios;
			public void actionPerformed(ActionEvent e) {
				
				Usuario usuarioLogueado = Usuario.login(inpMail.getText(), inpcontra.getText());
				

		        if (usuarioLogueado != null) {
		            JOptionPane.showMessageDialog(null, "Login exitoso. Bienvenido " + usuarioLogueado.getNombre());
		            //mostrarMenuUsuario(usuarioLogueado);
		        } else {
		        	lblerror.setText("Credenciales incorrectas. Intente de nuevo.");
		        }
			}
		});
		
		
		
		btnEnviar.setBounds(31, 209, 89, 23);
		contentPane.add(btnEnviar);
		
	
		
		inpcontra = new JPasswordField();
		inpcontra.setBounds(31, 146, 125, 20);
		contentPane.add(inpcontra);
		
		
		
	}
}
