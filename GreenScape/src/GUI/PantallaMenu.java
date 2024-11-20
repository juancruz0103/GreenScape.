package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class PantallaMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public PantallaMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel imgfondo = new JLabel("fondo");
		imgfondo.setIcon(new ImageIcon("C:/Users/User/OneDrive/Escritorio/GreenScape2-main/GreenScape2/GreenScape/GreenScape2/GreenScape/src/img/plantafondo.jpg"));
		imgfondo.setBounds(10, 21, 414, 150);
		contentPane.add(imgfondo);
		
		JButton btncurso = new JButton("Curso");
		btncurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PantallaCurso nuevo = new PantallaCurso();
				nuevo.setVisible(true);
				dispose();
			}
		});
		btncurso.setBounds(20, 182, 89, 23);
		contentPane.add(btncurso);
		
		
		JButton btntienda = new JButton("Tienda");
		btntienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PantallaTiendaUsuario nuevo = new PantallaTiendaUsuario(null);
				nuevo.setVisible(true);
				dispose();
			}
		});
		btntienda.setBounds(163, 182, 89, 23);
		contentPane.add(btntienda);
		
		JButton btnProgreso = new JButton("Progreso");
		btnProgreso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PantallaProgreso nuevo = new PantallaProgreso();
				nuevo.setVisible(true);
				dispose();
			}
		});
		btnProgreso.setBounds(296, 182, 89, 23);
		contentPane.add(btnProgreso);
		
		JButton btnsalir = new JButton("Salir");
		btnsalir.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        System.exit(0);
		    }
		});
		btnsalir.setBounds(163, 227, 89, 23);
		contentPane.add(btnsalir);
	}

}
