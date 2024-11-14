package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PantallaTienda extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public PantallaTienda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnatras = new JButton("Atras");
        btnatras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PantallaMenu nuevo = new PantallaMenu();
				nuevo.setVisible(true);
				dispose();
			}
		});
        btnatras.setBounds(313, 214, 89, 23);
        contentPane.add(btnatras);
	}

}
