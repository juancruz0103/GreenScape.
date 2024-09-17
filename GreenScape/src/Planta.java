
public class Planta {
    private String nombre;
    private int idPlanta;
    private String tipo;
    private String cuidadosEstacion;

    public Planta(String nombre, int idPlanta, String tipo, String cuidadosEstacion) {
        this.nombre = nombre;
        this.idPlanta = idPlanta;
        this.tipo = tipo;
        this.cuidadosEstacion = cuidadosEstacion;
    }

    // Por añadir con la base de datos: Logica para consultar cuidados.
    
    public void consultarCuidados() {
        
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdPlanta() {
        return idPlanta;
    }

    public void setIdPlanta(int idPlanta) {
        this.idPlanta = idPlanta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCuidadosEstacion() {
        return cuidadosEstacion;
    }

    public void setCuidadosEstacion(String cuidadosEstacion) {
        this.cuidadosEstacion = cuidadosEstacion;
    }
}
