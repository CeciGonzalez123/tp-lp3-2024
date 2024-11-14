package py.edu.uc.lp3.domain;

public class Jugador extends Usuario {
    protected int nivel;
    protected int puntos;
    public double tiempoJugado;

    // Constructor modificado
    public Jugador(String nombre, String apellido, Integer edad, Integer numeroCedula, String nombreUsuario, String contrasena, java.util.Date fechaRegistro, int nivel, int puntos, double tiempoJugado) {
        super(nombre, apellido, edad, numeroCedula, nombreUsuario, contrasena, fechaRegistro);
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
