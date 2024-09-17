import java.util.Date;

public class Proyecto {
    private String nombre;
    private int idProyecto;
    private Date fechaInicio;
    private String estado;

    public Proyecto(String nombre, int idProyecto, Date fechaInicio, String estado) {
        this.nombre = nombre;
        this.idProyecto = idProyecto;
        this.fechaInicio = fechaInicio;
        this.estado = estado;
    }
    
    // Para añadir con la base de datos: Logica para iniciar un proyecto, para mostrar el estado del proyecto.

    public void iniciarProyecto() {
       
    }

    public void mostrarEstado() {
        
    }

 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
