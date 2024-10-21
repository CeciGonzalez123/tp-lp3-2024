package py.edu.uc.lp3.apirestjava11;
import java.util.List;

public class Administrador extends Usuario {
    private List<String> privilegiosAdmin;
    public boolean activo;

    // Constructor
    public Administrador(int ci, String nombre, int edad, String email, String nombreUsuario, String contrasena, java.util.Date fechaRegistro, List<String> privilegiosAdmin, boolean activo) {
        super(ci, nombre, edad, email, nombreUsuario, contrasena, fechaRegistro);
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
