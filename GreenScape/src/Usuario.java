import java.util.List;

public class Usuario {
    private String nombre;
    private int idUsuario;
    private String email;
    private String contrasena;
    private String rol;


    public Usuario(String nombre, int idUsuario, String email, String contrasena, String rol) {
        this.nombre = nombre;
        this.idUsuario = idUsuario;
        this.email = email;
        this.contrasena = contrasena;
        this.rol = rol;
    }


    public static Usuario login(String email, String contrasena, List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getContrasena().equals(contrasena)) {
                return usuario; 
            }
        }
        return null; 
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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
}
