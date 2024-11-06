package BLL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import DLL.Conexion;

public class Usuario {
    private String nombre;
    private int idUsuario;
    private String email;
    private String contrasena;
    private String rol;


    public Usuario(String nombre, int idUsuario, String email, String contrasena, String rol) {
        this.nombre = nombre;
        this.idUsuario = idUsuario;
        this.email = email;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    private static Connection con = Conexion.getInstance().getConnection();
    
    public static Usuario login(String email, String contrasena) {     	
    	try (
    		PreparedStatement statement = (PreparedStatement) con.prepareStatement("SELECT * FROM usuario WHERE email = ?")) {	
    		statement.setString(1,email);	
    		ResultSet resultados = statement.executeQuery();
    	
    		if (resultados.next()){
    			String userCon = resultados.getString("contraseña");  
    		
    		if (userCon.equals(contrasena)) {
    				Usuario newUser = new Usuario (resultados.getString("nombre"), resultados.getInt("idusuario"), resultados.getString("email"), resultados.getString("contraseña"), resultados.getString("rol"));
    				return newUser;
    			}
    		} 
    		
    	} catch (SQLException p) {
    		p.printStackTrace();
    	}
    	
        return null; 
    }

    public static void save(String nombre, int idUsuario, String email, String contrasena, String rol) {
        String query = "INSERT INTO usuario (idusuario, nombre, email, contraseña, rol) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection con = Conexion.getInstance().getConnection();
             PreparedStatement statement = (PreparedStatement) con.prepareStatement(query)) {  // Sin necesidad de cast
            
            // Configura los parámetros de la consulta
            statement.setInt(1, idUsuario);
            statement.setString(2, nombre);
            statement.setString(3, email);
            statement.setString(4, contrasena);
            statement.setString(5, rol);
            
            // Ejecuta la consulta
            int filasAfectadas = statement.executeUpdate();
            
            if (filasAfectadas > 0) {
                System.out.println("Usuario registrado exitosamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();;
        }
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
