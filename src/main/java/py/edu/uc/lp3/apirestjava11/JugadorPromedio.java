package py.edu.uc.lp3.apirestjava11;
public class JugadorPromedio extends Jugador {
    protected int puntosPorPartida;
    public int numPartidasJugadas;

    // Constructor
    public JugadorPromedio(int ci, String nombre, int edad, String email, String nombreUsuario, String contrasena, java.util.Date fechaRegistro, int nivel, int puntos, double tiempoJugado, int puntosPorPartida, int numPartidasJugadas) {
        super(ci, nombre, edad, email, nombreUsuario, contrasena, fechaRegistro, nivel, puntos, tiempoJugado);
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
