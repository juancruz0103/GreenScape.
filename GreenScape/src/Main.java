import javax.swing.JOptionPane;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
       
        LinkedList<Usuario> usuarios = ListUsuario.getInstance();

        
        MenuPrincipal(usuarios);
    }

    
    public static void MenuPrincipal(LinkedList<Usuario> usuarios) {
        String[] MenuUsuario = {"Iniciar sesión", "Registrar usuario", "Salir"};
        int IdMenu;

        do {
            IdMenu = JOptionPane.showOptionDialog(null, "Bienvenido a la plataforma de GreenScape. Elija una opción", null, 0, JOptionPane.QUESTION_MESSAGE, null, MenuUsuario, MenuUsuario[0]);

            switch (IdMenu) {
                case 0: 
                    iniciarSesion(usuarios);
                    break;

                case 1: 
                    registrarUsuario();
                    break;

                case 2: 
                    JOptionPane.showMessageDialog(null, "Gracias por participar en la demo de GreenScape.");
                    break;

                default:
                    break;
            }
        } while (IdMenu != 2);  
    }

    
    
    public static void iniciarSesion(LinkedList<Usuario> usuarios) {
        String email = JOptionPane.showInputDialog("Ingrese su email:");
        String contrasena = JOptionPane.showInputDialog("Ingrese su contraseña:");

        Usuario usuarioLogueado = Usuario.login(email, contrasena, usuarios);

        if (usuarioLogueado != null) {
            JOptionPane.showMessageDialog(null, "Login exitoso. Bienvenido " + usuarioLogueado.getNombre());
            mostrarMenuUsuario(usuarioLogueado);
        } else {
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas. Intente de nuevo.");
        }
    }

    public static void registrarUsuario() {
        String nombre = JOptionPane.showInputDialog("Ingrese nombre");

        int idUsuario;
        try {
            idUsuario = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un id numerico de usuario para identificarlo"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID de usuario no válido. Debe ser un número.");
            return;
        }

        String email = JOptionPane.showInputDialog("Ingrese email");
        String contrasena = JOptionPane.showInputDialog("Ingrese contraseña");
        String rol = JOptionPane.showInputDialog("Ingrese rol (usuario, estudiante)");

        Usuario nuevoUsuario = new Usuario(nombre, idUsuario, email, contrasena, rol);
        ListUsuario.guardar(nuevoUsuario);
        JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente.");
    }


    public static void mostrarMenuUsuario(Usuario usuarioLogueado) {
        String[] opcionesUsuario = {"Mis proyectos", "Ir a tienda", "Ver progreso", "Salir"};
        int opcionE;

        do {
            opcionE = JOptionPane.showOptionDialog(null, "(GreenScape) Menu general", "", 0, JOptionPane.QUESTION_MESSAGE, null, opcionesUsuario, opcionesUsuario[0]);

            switch (opcionE) {
                case 0: 
                    mostrarProyectos();
                    break;

                case 1: // Ir a tienda 
                	
                    if (usuarioLogueado.getRol().equalsIgnoreCase("usuario")) {
                        gestionarTienda();
                        
                    } else if (usuarioLogueado.getRol().equalsIgnoreCase("almacen")) {
                        JOptionPane.showMessageDialog(null, "Bienvenido almacenero.");
                        gestionarTienda();
                    }
                    break;

                case 2: 
                    mostrarProgreso();
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Saliendo del menú del usuario.");
                    break;

                default:
                    break;
            }
        } while (opcionE != 3);  
    }

    public static void mostrarProyectos() {
        LinkedList<Proyecto> proyectos = Listproyectos.getInstance(); 

        if (proyectos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay proyectos registrados.");
            return;
        }

        StringBuilder listaProyectos = new StringBuilder();
        listaProyectos.append("Proyectos:\n");

        for (Proyecto proyecto : proyectos) {
            listaProyectos.append("ID: ").append(proyecto.getIdProyecto())
                          .append(", Nombre: ").append(proyecto.getNombre())
                          .append(", Fecha de Inicio: ").append(proyecto.getFechaInicio())
                          .append(", Estado: ").append(proyecto.getEstado())
                          .append("\n");
        }

        JOptionPane.showMessageDialog(null, listaProyectos.toString());
    }


    public static void mostrarProgreso() {
        JOptionPane.showMessageDialog(null, "Progreso del usuario.");
     
        // por agregar
    }

    // Gestionar tienda usuario
    
    public static void gestionarTienda() {
        String[] opcionesTienda = {"Ver productos", "Agregar producto", "Eliminar producto", "Salir"};
        int opcionTienda = JOptionPane.showOptionDialog(null, "Gestión de la tienda", "", 0, JOptionPane.QUESTION_MESSAGE, null, opcionesTienda, opcionesTienda[0]);

        switch (opcionTienda) {
            case 0: 
                LinkedList<Producto> productos = AdministradorAlmacen.mostrarProducto();
                JOptionPane.showMessageDialog(null, productos);
                break;

            case 1: 
            	
            	// Agregar producto
                
                break;

            case 2: 
            	
            	// Eliminar producto
             
                break;

            case 3:
            	
            	// Salir de la tienda
            	
                break;

            default:
                break;
        }
    }
}
