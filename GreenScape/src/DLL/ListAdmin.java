package DLL;

import java.util.LinkedList;

import BLL.Administrador;


public class ListAdmin {
	
	private static LinkedList<Administrador> Admins;
	
	public static LinkedList<Administrador> getInstance(){
		if (Admins==null) {
			Admins = new LinkedList<Administrador>();
			ListaAdmins();
		} else {
			System.out.println("La lista ya existe");
		}
		return Admins;
	}
	
	public static void guardar(Administrador administrador){
		Admins.add(administrador);
	}
	
	public static void ListaAdmins() {
		Admins.add(new Administrador("Juan",1 ,"Juan@gmail.com"));
		Admins.add(new Administrador("Lucas",2 ,"Lucas@gmail.com"));
		Admins.add(new Administrador("Andres",3 ,"Andres@gmail.com"));
		
	}

}
