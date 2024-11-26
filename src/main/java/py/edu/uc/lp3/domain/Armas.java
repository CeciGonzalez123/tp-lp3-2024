package py.edu.uc.lp3.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Armas")
public class Armas extends Producto {
    private int daño;
    private double alcance;
    private int municion;

    // Constructor sin parámetros
    public Armas() {}

    // Constructor con parámetros
    public Armas(int id_producto, String nombre, double precio, boolean disponibilidad, int daño, double alcance, int municion) {
        super(id_producto, nombre, precio, disponibilidad);
        this.daño = daño;
        this.alcance = alcance;
        this.municion = municion;
    }

    // Getters y Setters
    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

    public double getAlcance() {
        return alcance;
    }

    public void setAlcance(double alcance) {
        this.alcance = alcance;
    }

    public int getMunicion() {
        return municion;
    }

    public void setMunicion(int municion) {
        this.municion = municion;
    }
}
