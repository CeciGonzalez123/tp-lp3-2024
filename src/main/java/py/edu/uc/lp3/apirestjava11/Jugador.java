package py.edu.uc.lp3.apirestjava11;
public class Jugador extends Usuario {
    protected int nivel;
    protected int puntos;
    public double tiempoJugado;

    // Constructor
    public Jugador(int ci, String nombre, int edad, String email, String nombreUsuario, String contrasena, java.util.Date fechaRegistro, int nivel, int puntos, double tiempoJugado) {
        super(ci, nombre, edad, email, nombreUsuario, contrasena, fechaRegistro);
        this.nivel = nivel;
        this.puntos = puntos;
        this.tiempoJugado = tiempoJugado;
    }

    // Getters y Setters
    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public double getTiempoJugado() {
        return tiempoJugado;
    }

    public void setTiempoJugado(double tiempoJugado) {
        this.tiempoJugado = tiempoJugado;
    }
}
