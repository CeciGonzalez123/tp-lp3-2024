package py.edu.uc.lp3.domain;

public class Usuario extends Persona {
    protected String nombreUsuario;
    private String contrasena;
    public java.util.Date fechaRegistro;

    // Constructor modificado
    public Usuario(String nombre, String apellido, Integer edad, Integer numeroCedula, String nombreUsuario, String contrasena, java.util.Date fechaRegistro) {
        super(nombre, apellido, edad, numeroCedula); // Llama al constructor de Persona con los parámetros correctos
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
