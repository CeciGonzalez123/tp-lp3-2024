package py.edu.uc.lp3.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("Administrador")
public class Administrador extends Usuario {
    @ElementCollection
    private List<String> privilegiosAdmin;
    public boolean activo;

    // Constructor sin parámetros (necesario para JPA)
    public Administrador() {
        super(); // Llamar al constructor sin parámetros de la superclase
    }

    // Constructor con parámetros
    public Administrador(String nombre, String apellido, Integer edad, Integer numeroCedula, String nombreUsuario, String contrasena, Date fechaRegistro, List<String> privilegiosAdmin, boolean activo) {
        super(nombre, apellido, edad, numeroCedula, nombreUsuario, contrasena, fechaRegistro);
        this.privilegiosAdmin = privilegiosAdmin;
        this.activo = activo;
    }

    // Getters y Setters
    public List<String> getPrivilegiosAdmin() {
        return privilegiosAdmin;
    }

    public void setPrivilegiosAdmin(List<String> privilegiosAdmin) {
        this.privilegiosAdmin = privilegiosAdmin;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
