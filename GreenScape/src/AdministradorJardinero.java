import java.util.LinkedList;

public class AdministradorJardinero extends Administrador {
    private LinkedList<Progreso> progresoSupervisado;

    public AdministradorJardinero(String nombre, int idAdmin, String email, LinkedList<Progreso> progresoSupervisado) {
        super(nombre, idAdmin, email);
        this.progresoSupervisado = progresoSupervisado;
    }
    
    // Para añadir con la base de datos: Lógica para gestionar información, para supervisar progreso.

    public void gestionarInformacion() {
        
    }

    public void supervisarProgreso() {
        
    }

    
    public LinkedList<Progreso> getProgresoSupervisado() {
        return progresoSupervisado;
    }

    public void setProgresoSupervisado(LinkedList<Progreso> progresoSupervisado) {
        this.progresoSupervisado = progresoSupervisado;
    }
}
