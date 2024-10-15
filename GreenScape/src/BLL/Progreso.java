package BLL;
import java.util.Date;

public class Progreso {
    private int idProgreso;
    private Date fecha;
    private String detalle;
    private int checkpoints;

    public Progreso(int idProgreso, Date fecha, String detalle, int checkpoints) {
        this.idProgreso = idProgreso;
        this.fecha = fecha;
        this.detalle = detalle;
        this.checkpoints = checkpoints;
    }

    // Por añadir con la base de datos: logica para mostrarProgreso.
    
    public void mostrarProgreso() {
        
    }

    
    public int getIdProgreso() {
        return idProgreso;
    }

    public void setIdProgreso(int idProgreso) {
        this.idProgreso = idProgreso;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getCheckpoints() {
        return checkpoints;
    }

    public void setCheckpoints(int checkpoints) {
        this.checkpoints = checkpoints;
    }
}
