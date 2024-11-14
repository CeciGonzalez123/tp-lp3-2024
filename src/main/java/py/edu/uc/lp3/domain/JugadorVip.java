package py.edu.uc.lp3.domain;

import java.util.Date;
import java.util.List;

public class JugadorVip extends Jugador {
    public List<String> beneficiosVip;
    public boolean suscripcionActiva;

    // Constructor modificado
    public JugadorVip(String nombre, String apellido, Integer edad, Integer numeroCedula, String nombreUsuario, String contrasena, Date fechaRegistro, int nivel, int puntos, double tiempoJugado, List<String> beneficiosVip, boolean suscripcionActiva) {
        super(nombre, apellido, edad, numeroCedula, nombreUsuario, contrasena, fechaRegistro, nivel, puntos, tiempoJugado);
        this.beneficiosVip = beneficiosVip;
        this.suscripcionActiva = suscripcionActiva;
    }

    // Getters y Setters
    public List<String> getBeneficiosVip() {
        return beneficiosVip;
    }

    public void setBeneficiosVip(List<String> beneficiosVip) {
        this.beneficiosVip = beneficiosVip;
    }

    public boolean isSuscripcionActiva() {
        return suscripcionActiva;
    }

    public void setSuscripcionActiva(boolean suscripcionActiva) {
        this.suscripcionActiva = suscripcionActiva;
    }
}
