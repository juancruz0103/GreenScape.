import java.util.LinkedList;

public class Usuario {
    private String nombre;
    private int idUsuario;
    private String email;
    private LinkedList<Proyecto> proyectos;
    private LinkedList<Reseña> reseñas;

    public Usuario(String nombre, int idUsuario, String email, LinkedList<Proyecto> proyectos, LinkedList<Reseña> reseñas) {
        this.nombre = nombre;
        this.idUsuario = idUsuario;
        this.email = email;
        this.proyectos = proyectos;
        this.reseñas = reseñas;
    }
    
    // Para añadir con la base de datos: Logica para ingresar progreso, para consultar planta.

    public void ingresarProgreso(Progreso progreso) {
        
    }

    public void consultarPlanta(Planta planta) {
        
    }

    public void dejarReseña(Reseña reseña) {
    	// Para añadir con la base de datos: reseñas.add(reseña);
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

    public LinkedList<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(LinkedList<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public LinkedList<Reseña> getReseñas() {
        return reseñas;
    }

    public void setReseñas(LinkedList<Reseña> reseñas) {
        this.reseñas = reseñas;
    }
}
