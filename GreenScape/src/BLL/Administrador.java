package BLL;

public class Administrador {
	private String nombre;
	private int idAdmin;
	protected static String email;
	
	public Administrador(String nombre, int idAdmin, String email) {
		
		this.nombre = nombre;
		this.idAdmin = idAdmin;
		this.email = email;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
