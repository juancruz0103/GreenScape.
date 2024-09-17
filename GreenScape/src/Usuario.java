import java.util.List;

public class Usuario {
    private String nombre;
    private int idUsuario;
    private String email;
    private List<Proyecto> proyectos;
    private List<Reseña> reseñas;

    public Usuario(String nombre, int idUsuario, String email, List<Proyecto> proyectos, List<Reseña> reseñas) {
        this.nombre = nombre;
        this.idUsuario = idUsuario;
        this.email = email;
        this.proyectos = proyectos;
        this.reseñas = reseñas;
    }
    
    // Por añadir con la base de datos: Logica para ingresar progreso, consultar planta

    public void ingresarProgreso(Progreso progreso) {
        
    }

    public void consultarPlanta(Planta planta) {
        
    }

    public void dejarReseña(Reseña reseña) {
    	
        // Por añadir con la base de datos: reseñas.add(reseña);
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public List<Reseña> getReseñas() {
        return reseñas;
    }

    public void setReseñas(List<Reseña> reseñas) {
        this.reseñas = reseñas;
    }
}
