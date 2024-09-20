 import java.util.LinkedList;

public class ListUsuario {

	private static 	LinkedList<Usuario> usuarios;

	public static LinkedList<Usuario> getInstance(){
		if (usuarios==null) {
			usuarios = new LinkedList<Usuario>();
			ListaAdmin();		
		} else {	
			System.out.println("La lista ya existe");
		}	
		return usuarios;
	}
	public static void guardar(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public static void ListaAdmin() {
		usuarios.add(new  Usuario("Andres",0 ,"Andres@gmail.com","Andrespass", "Admin"));
		usuarios.add(new  Usuario("Juan",0 ,"Juan@gmail.com","Juanpass", "Admin"));
		usuarios.add(new  Usuario("Lucas",0 ,"Lucas@gmail.com","Lucasspass", "Admin"));

	}
}
