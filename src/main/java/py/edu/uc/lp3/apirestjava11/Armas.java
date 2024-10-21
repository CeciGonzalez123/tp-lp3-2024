package py.edu.uc.lp3.apirestjava11;

public class Armas extends Producto {
    public int daño;
    protected double alcance;
    protected int municion;

    // Constructor
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
