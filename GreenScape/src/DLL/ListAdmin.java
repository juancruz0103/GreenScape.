package DLL;

import java.util.LinkedList;

import BLL.Administrador;

public class ListAdmin {
	
	private static LinkedList<ListAdmin> admins;
	
	public static LinkedList<ListAdmin> getInstance(){
		if (admins==null) {
			admins = new LinkedList<ListAdmin>();
			ListaAdmins();
		} else {
			System.out.println("La lista ya existe");
		}
		return admins;
	}
	
	public static void guardar(Administrador administrador){
		admins.add(administrador);
	}
	
	public static void ListaAdmins() {
		admins.add(new Administrador("Juan",1 ,"Juan@gmail.com"));
		admins.add(new Administrador("Lucas",2 ,"Lucas@gmail.com"));
		admins.add(new Administrador("Andres",3 ,"Andres@gmail.com"));
		
	}

}
