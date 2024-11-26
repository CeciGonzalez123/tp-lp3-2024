package py.edu.uc.lp3.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("JugadorPromedio")
public class JugadorPromedio extends Jugador {

    // Constructor sin parámetros
    public JugadorPromedio() {
        super();
    }

    // Constructor con parámetros
    public JugadorPromedio(String nombre, String apellido, Integer edad, Integer numeroCedula, String nombreUsuario, String contrasena, Date fechaRegistro, int nivel, int puntos, double tiempoJugado) {
        super(nombre, apellido, edad, numeroCedula, nombreUsuario, contrasena, fechaRegistro, nivel, puntos, tiempoJugado);
    }
}
