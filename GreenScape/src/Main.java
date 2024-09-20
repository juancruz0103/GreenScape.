import javax.swing.JOptionPane;
import java.util.LinkedList;
import java.util.List;

 
public class Main {

	public static void main(String[] args) {
		
		// Administradores.
        
        List<Usuario> usuarios = new LinkedList<>();
        usuarios.add(new Usuario("Admin", 1, "admin@gmail.com", "adminpass", "admin"));
        usuarios.add(new Usuario("Jardinero", 2, "jardinero@gmail.com", "jardineropass", "jardinero"));
        usuarios.add(new Usuario("Almacen", 3, "almacen@gmail.com", "almacenpass", "almacen"));
        
        String[] MenuUsuario = {"Iniciar sesión","Registrar usuario", "Salir"};
        int IdMenu =0;
        do { IdMenu= JOptionPane.showOptionDialog(null, "Elija una opción", null, 0, 0, null, MenuUsuario, MenuUsuario[0]);
        	switch (IdMenu) { 
        	
        	case 0:
                String email = JOptionPane.showInputDialog("Ingrese su email:");
                String contrasena = JOptionPane.showInputDialog("Ingrese su contraseña:");

                Usuario usuarioLogueado = Usuario.login(email, contrasena, usuarios);

                if (usuarioLogueado != null) {
                    JOptionPane.showMessageDialog(null, "Login exitoso. Bienvenido " + usuarioLogueado.getNombre());
                    
                    
                    String[] opcionessuario = {"Mis proyectos","ir a tienda","Ver progreso","Salir"};
                    
                    
                    String[] proyectos = {"Ver proyectos activos","Concluidos","Filtrar","Salir"};
                        
                    
                    int elegido = JOptionPane.showOptionDialog(null, "Opciones generales", "", 0, 0, null, opcionessuario, opcionessuario[0]);
                    
                    switch (elegido) {
					case 0: 
	                    elegido = JOptionPane.showOptionDialog(null, "Proyectos", "", 0, 0, null, proyectos, proyectos[0]);

						
						break;
					case 1: 
								
						// ir a tienda
						
						break;
                    case 2: 
						
						// Ver progreso
				    break;
				    
                    case 3: 
						
						// Abandonar el programa
                    	
				    break;
				    
                    }
						
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales incorrectas. Intente de nuevo.");
                }
                break;
            
         
            case 1:
                String nombre = JOptionPane.showInputDialog("Ingrese nombre");
                
                
                int idUsuario;
                try {
                    idUsuario = Integer.parseInt(JOptionPane.showInputDialog("Ingrese idUsuario"));
                } catch (NumberFormatException A) {
                    JOptionPane.showMessageDialog(null, "ID de usuario no válido. Debe ser un número.");
                    break;
                }
                
                email = JOptionPane.showInputDialog("Ingrese email");
                contrasena = JOptionPane.showInputDialog("Ingrese contraseña");
                String rol = JOptionPane.showInputDialog("Ingrese rol");

                
                Usuario nuevoUsuario = new Usuario(nombre, idUsuario, email, contrasena, rol);
                ListUsuario.getInstance().add(nuevoUsuario);
                JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente.");
                break;
            
            
            case 2:
                JOptionPane.showMessageDialog(null, "Gracias por participar en la demo de GreenScape");
                break;
            
            default:
                break;
        }

    } while (IdMenu != 2); 
}
}