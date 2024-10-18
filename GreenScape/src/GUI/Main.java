package GUI;
import javax.swing.JOptionPane;
import BLL.Listproyectos;
import BLL.Producto;
import BLL.Proyecto;
import BLL.Usuario;
import DLL.AdministradorAlmacen;
import DLL.ListUsuario;

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
    
    public static boolean validarContraseña( String contrasena){
    	boolean flag = true;
    	boolean validarChar = false;
    	boolean validarMayus = false; 
    	boolean validarMinus = false; 
    	boolean validarNum = false; 
    	
    	for (int j = 0; j < contrasena.length(); j++) {
        	char c = contrasena.charAt(j);
        	// Contraseña 8 caracteres, 1 num, 1 mayus, 1 minus.   	
        	
        	if (contrasena.length() >= 8 ) {
        		validarChar = true;
        		for (int i = 0; i < contrasena.length(); i++) {
					
        			if (Character.isDigit(contrasena.charAt(i))) {
        				validarNum = true;
					}
        			if (Character.isUpperCase(contrasena.charAt(i))) {
        				validarMayus = true;
					}
        			if (Character.isLowerCase(contrasena.charAt(i))) {	
        				validarMinus = true;
        			}
        		}
        	}
        }   	 
    	
    	
    	  if(!validarChar){
    		JOptionPane.showMessageDialog(null, "Tiene que tener 8 caracteres como minimo.");
    	  }
    	
    	  if(!validarMayus){
          	JOptionPane.showMessageDialog(null, "Una mayuscula como minimo.");
          }
        
          if(!validarMinus){
          	JOptionPane.showMessageDialog(null, "Una minuscula como minimo.");
          }
          
          if(!validarNum){
          	JOptionPane.showMessageDialog(null, "tiene que contener numeros.");
          }
          
          if(validarChar && validarMayus && validarMinus && validarNum == true){
        	  flag = true;
          }else {
        	  flag = false;
          }
          
          
          return flag;
        	
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
        String contrasena;
        boolean validar;
        
        do {
        	contrasena = JOptionPane.showInputDialog("Ingrese contraseña");
        	validar = validarContraseña(contrasena);	
		} while (validar==false);    
        
        String rol = JOptionPane.showInputDialog("Ingrese rol (usuario, estudiante)");

        Usuario nuevoUsuario = new Usuario(nombre, idUsuario, email, contrasena, rol);
        ListUsuario.guardar(nuevoUsuario);
        JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente.");
    }


    public static void mostrarMenuUsuario(Usuario usuarioLogueado) {
        String[] opcionesUsuario = {"Curso", "Ir a tienda", "Ver progreso", "Salir"};
        int opcionE;

        do {
            opcionE = JOptionPane.showOptionDialog(null, "(GreenScape) Menu general", "", 0, JOptionPane.QUESTION_MESSAGE, null, opcionesUsuario, opcionesUsuario[0]);

            switch (opcionE) {
                case 0: 
                    mostrarProyectos();
                    break;

                case 1: 
                    gestionarTienda(usuarioLogueado);
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
    
    public static void gestionarTienda(Usuario usuarioLogueado) {
        String[] opcionesTienda;

        // Si es usuario, solo puede ver productos y realizar compras
        if (usuarioLogueado.getRol().equalsIgnoreCase("usuario")) {
            opcionesTienda = new String[]{"Ver productos", "Comprar productos", "Salir"};
        } 
   
        else if (usuarioLogueado.getRol().equalsIgnoreCase("almacen")) {
            opcionesTienda = new String[]{"Ver productos", "Agregar producto", "Actualizar producto", "Eliminar producto", "Salir"};
        } else {
            JOptionPane.showMessageDialog(null, "Rol no autorizado para gestionar la tienda.");
            return;
        }

        int opcionTienda = JOptionPane.showOptionDialog(null, "Gestión de la tienda", "", 0, JOptionPane.QUESTION_MESSAGE, null, opcionesTienda, opcionesTienda[0]);

        switch (opcionTienda) {
            case 0: // Ver productos
                LinkedList<Producto> productos = AdministradorAlmacen.mostrarProducto();
                StringBuilder listaProductos = new StringBuilder();
                listaProductos.append("Productos disponibles:\n");

                for (Producto producto : productos) {
                    listaProductos.append("ID: ").append(producto.getIdProducto())
                                  .append(": ").append(producto.getNombre())
                                  .append(", Descripción: ").append(producto.getDescripcion())
                                  .append(", Stock actual: ").append(producto.getStock())
                                  .append(", Precio: $").append(producto.getPrecio())
                                  .append("\n");
                }

                JOptionPane.showMessageDialog(null, listaProductos.toString());
                break;

            // Funcionalidades para los usuarios
            case 1:
                if (usuarioLogueado.getRol().equalsIgnoreCase("usuario")) {
                    realizarCompra(usuarioLogueado);
                } else if (usuarioLogueado.getRol().equalsIgnoreCase("almacen")) {
                    // Almacenero: agregar producto
                    String nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
                    String descripcion = JOptionPane.showInputDialog("Ingrese una descripción del producto:");
                    int stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad en stock:"));
                    double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto:"));

                    Producto nuevoProducto = new Producto(nombreProducto, descripcion, stock, precio);
                    AdministradorAlmacen.crearProducto(nuevoProducto);
                }
                break;

            // Solo para los almaceneros
            case 2: 
                if (usuarioLogueado.getRol().equalsIgnoreCase("almacen")) {
                    int idProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto a actualizar:"));
                    String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre del producto:");
                    String nuevaDescripcion = JOptionPane.showInputDialog("Nueva descripción del producto:");
                    int nuevoStock = Integer.parseInt(JOptionPane.showInputDialog("Nuevo stock del producto:"));
                    double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog("Nuevo precio del producto:"));

                    Producto productoActualizado = new Producto(idProducto, nuevoNombre, nuevaDescripcion, nuevoStock, nuevoPrecio);
                    AdministradorAlmacen.actualizarProducto(productoActualizado);
                }
                break;

            case 3: 
                if (usuarioLogueado.getRol().equalsIgnoreCase("almacen")) {
                    int idProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto a eliminar:"));
                    AdministradorAlmacen.eliminarProducto(idProducto);
                }
                break;

            case 4:
                // Salir
                break;

            default:
                break;
        }
    }

    public static void realizarCompra(Usuario usuarioLogueado) {
        LinkedList<Producto> productos = AdministradorAlmacen.mostrarProducto();
        StringBuilder listaProductos = new StringBuilder();
        listaProductos.append("Productos disponibles:\n");

        for (Producto producto : productos) {
            listaProductos.append("ID: ").append(producto.getIdProducto())
                          .append(", Nombre: ").append(producto.getNombre())
                          .append(", Precio: $").append(producto.getPrecio())
                          .append("\n");
        }

        JOptionPane.showMessageDialog(null, listaProductos.toString());

        // Simular compra (Pendiente)
        int idProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto que desea comprar:"));
        Producto productoSeleccionado = null;

        for (Producto producto : productos) {
            if (producto.getIdProducto() == idProducto) {
                productoSeleccionado = producto;
                break;
            }
        }

        if (productoSeleccionado != null) {
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad que desea comprar:"));
            double total = productoSeleccionado.getPrecio() * cantidad;
            JOptionPane.showMessageDialog(null, "Compra realizada exitosamente. Total: $" + total);
            
        } else {
            JOptionPane.showMessageDialog(null, "Producto no encontrado.");
        }
    }


}