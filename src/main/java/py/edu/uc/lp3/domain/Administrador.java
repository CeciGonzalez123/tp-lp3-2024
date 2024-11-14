package py.edu.uc.lp3.domain;

import java.util.Date;
import java.util.List;

public class Administrador extends Usuario {
    private List<String> privilegiosAdmin;
    public boolean activo;

    // Constructor modificado
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
