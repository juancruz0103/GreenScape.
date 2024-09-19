import javax.swing.JOptionPane;
import java.util.LinkedList;
import java.util.List;

 
public class Main {

	public static void main(String[] args) {
        
        List<Usuario> usuarios = new LinkedList<>();
        usuarios.add(new Usuario("Admin", 1, "admin@gmail.com", "adminpass", "admin"));
        usuarios.add(new Usuario("Jardinero", 2, "jardinero@gmail.com", "jardineropass", "jardinero"));
        usuarios.add(new Usuario("Almacen", 3, "almacen@gmail.com", "almacenpass", "almacen"));

        
        String email = JOptionPane.showInputDialog("Ingrese su email:");
        String contrasena = JOptionPane.showInputDialog("Ingrese su contraseña:");

      
        Usuario usuarioLogueado = Usuario.login(email, contrasena, usuarios);

        if (usuarioLogueado != null) {
            JOptionPane.showMessageDialog(null, "Login exitoso. Bienvenido " + usuarioLogueado.getNombre());


        } else {
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas. IntenteLO de nuevo.");
        }
	}

}
