package BLL;

public class Curso {
    private int idjardinero;
    private String nombre;
    private String descripcion;

    public Curso(int idjardinero, String nombre, String descripcion) {
        this.idjardinero = idjardinero;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public Curso(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public int getIdCurso() {
        return idjardinero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getinformacion() {
        return descripcion;
    }
 

	

}