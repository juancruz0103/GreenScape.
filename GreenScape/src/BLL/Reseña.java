package BLL;
import java.util.Date;

public class Reseña {
    private String contenido;
    private int idReseña;
    private Date fecha;
    private int idUsuario;

    public Reseña(String contenido, int idReseña, Date fecha, int idUsuario) {
        this.contenido = contenido;
        this.idReseña = idReseña;
        this.fecha = fecha;
        this.idUsuario = idUsuario;
    }
    
   // Para añadir con la base de datos: Logica para añadir reseñas.

    public void escribirReseña() {
       
    }


    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getIdReseña() {
        return idReseña;
    }

    public void setIdReseña(int idReseña) {
        this.idReseña = idReseña;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
