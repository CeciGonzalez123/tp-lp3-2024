package py.edu.uc.lp3.apirestjava11;
public class Usuario extends Persona {
    protected String nombreUsuario;
    private String contrasena;
    public java.util.Date fechaRegistro;

    // Constructor
    public Usuario(int ci, String nombre, int edad, String email, String nombreUsuario, String contrasena, java.util.Date fechaRegistro) {
        super(ci, nombre, edad, email);
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.fechaRegistro = fechaRegistro;
    }

    // Getters y Setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public java.util.Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(java.util.Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
