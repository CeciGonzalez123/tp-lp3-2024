package py.edu.uc.lp3.apirestjava11;
import java.util.List;

public class JugadorVip extends Jugador {
    public List<String> beneficiosVip;
    public boolean suscripcionActiva;

    // Constructor
    public JugadorVip(int ci, String nombre, int edad, String email, String nombreUsuario, String contrasena, java.util.Date fechaRegistro, int nivel, int puntos, double tiempoJugado, List<String> beneficiosVip, boolean suscripcionActiva) {
        super(ci, nombre, edad, email, nombreUsuario, contrasena, fechaRegistro, nivel, puntos, tiempoJugado);
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