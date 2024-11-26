package py.edu.uc.lp3.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("JugadorVip")
public class JugadorVip extends Jugador {
    private boolean vip;

    // Constructor sin parámetros
    public JugadorVip() {
        super();
    }

    // Constructor con parámetros
    public JugadorVip(String nombre, String apellido, Integer edad, Integer numeroCedula, String nombreUsuario, String contrasena, Date fechaRegistro, int nivel, int puntos, double tiempoJugado, boolean vip) {
        super(nombre, apellido, edad, numeroCedula, nombreUsuario, contrasena, fechaRegistro, nivel, puntos, tiempoJugado);
        this.vip = vip;
    }

    // Getters y Setters
    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
}
