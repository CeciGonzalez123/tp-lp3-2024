package py.edu.uc.lp3.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("Jugador")
public class Jugador extends Usuario {
    protected int nivel;
    protected int puntos;
    public double tiempoJugado;

    // Constructor sin parámetros (necesario para JPA)
    public Jugador() {
        super(); // Llamar al constructor sin parámetros de la superclase
    }

    // Constructor con parámetros
    public Jugador(String nombre, String apellido, Integer edad, Integer numeroCedula, String nombreUsuario, String contrasena, Date fechaRegistro, int nivel, int puntos, double tiempoJugado) {
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
