package DLL;
import java.sql.DriverManager;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

public class Conexion {
	
	private static final String URL="jdbc:mysql://localhost:3307/greenscape";
	private static final String USER="root";
	private static final String PASS= "";
	
	private static Conexion instance;
	
	private Connection con;
	
	private Conexion() {
		try {
			con = (Connection) DriverManager.getConnection(URL, USER, PASS);
			//JOptionPane.showMessageDialog(null, "Se conecto");
		}catch (SQLException e) {
			//JOptionPane.showMessageDialog(null, "No se conecto");
			
		}	
	}
	
	public static Conexion getInstance() {
		if (instance==null) {
			instance = new Conexion();
		}
		return instance;
	}
	
	public Connection getConnection() {
		return con; 
	}
	

}
   