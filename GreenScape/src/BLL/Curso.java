package BLL;

public class Curso {
    private int idCurso;
    private String nombre;
    private String informacion;

    public Curso(int idCurso, String nombre, String descripcion, String informacion) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.informacion = informacion;
    }

    // Getters y Setters
    public int getIdCurso() {
        return idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return informacion;
    }

}

