import java.util.List;

public class AdministradorJardinero extends Administrador {
    private List<Progreso> progresoSupervisado;

    public AdministradorJardinero(String nombre, int idAdmin, String email, List<Progreso> progresoSupervisado) {
        super(nombre, idAdmin, email);
        this.progresoSupervisado = progresoSupervisado;
    }
    
    // Para añadir con la base de datos: Logica para gestionar información, Supervisar progreso.
    

    public void gestionarInformacion() {
        
    }

    public void supervisarProgreso() {
       
    }

    public List<Progreso> getProgresoSupervisado() {
        return progresoSupervisado;
    }

    public void setProgresoSupervisado(List<Progreso> progresoSupervisado) {
        this.progresoSupervisado = progresoSupervisado;
    }
}
