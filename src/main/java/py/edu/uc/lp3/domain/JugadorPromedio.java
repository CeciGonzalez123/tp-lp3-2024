package py.edu.uc.lp3.domain;

import java.util.Date;

public class JugadorPromedio extends Jugador {
    protected int puntosPorPartida;
    public int numPartidasJugadas;

    // Constructor modificado
    public JugadorPromedio(String nombre, String apellido, Integer edad, Integer numeroCedula, String nombreUsuario, String contrasena, Date fechaRegistro, int nivel, int puntos, double tiempoJugado, int puntosPorPartida, int numPartidasJugadas) {
        super(nombre, apellido, edad, numeroCedula, nombreUsuario, contrasena, fechaRegistro, nivel, puntos, tiempoJugado);
        this.puntosPorPartida = puntosPorPartida;
        this.numPartidasJugadas = numPartidasJugadas;
    }

    // Getters y Setters
    public int getPuntosPorPartida() {
        return puntosPorPartida;
    }

    public void setPuntosPorPartida(int puntosPorPartida) {
        this.puntosPorPartida = puntosPorPartida;
    }

    public int getNumPartidasJugadas() {
        return numPartidasJugadas;
    }

    public void setNumPartidasJugadas(int numPartidasJugadas) {
        this.numPartidasJugadas = numPartidasJugadas;
    }
}
