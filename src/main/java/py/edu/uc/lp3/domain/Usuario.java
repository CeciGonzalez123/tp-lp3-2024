package py.edu.uc.lp3.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("Usuario")
public class Usuario extends Persona {
    protected String nombreUsuario;
    private String contrasena;
    public Date fechaRegistro;

    // Constructor
    public Usuario(String nombre, String apellido, Integer edad, Integer numeroCedula, String nombreUsuario, String contrasena, Date fechaRegistro) {
        super(nombre, apellido, edad, numeroCedula);
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.fechaRegistro = fechaRegistro;
    }

    // Constructor sin parámetros (necesario para JPA)
    public Usuario() {}

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

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}

