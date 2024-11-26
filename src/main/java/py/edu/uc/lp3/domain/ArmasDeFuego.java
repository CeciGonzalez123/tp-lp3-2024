package py.edu.uc.lp3.domain;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ArmasDeFuego")
public class ArmasDeFuego extends Armas {
    public String tipoMunicion;
    protected double cadencia;

    // Constructor
    public ArmasDeFuego(int id_producto, String nombre, double precio, boolean disponibilidad, int daño, double alcance, int municion, String tipoMunicion, double cadencia) {
        super(id_producto, nombre, precio, disponibilidad, daño, alcance, municion);
        this.tipoMunicion = tipoMunicion;
        this.cadencia = cadencia;
    }

    // Getters y Setters
    public String getTipoMunicion() {
        return tipoMunicion;
    }

    public void setTipoMunicion(String tipoMunicion) {
        this.tipoMunicion = tipoMunicion;
    }

    public Double getCadencia() {
        return cadencia;
    }

    public void setCadencia(double cadencia) {
        this.cadencia = cadencia;
    }
}
