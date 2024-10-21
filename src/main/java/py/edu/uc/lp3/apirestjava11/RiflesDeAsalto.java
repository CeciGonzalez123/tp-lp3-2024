package py.edu.uc.lp3.apirestjava11;

public class RiflesDeAsalto extends ArmasDeFuego {
    public double precision;
    public double peso;

    // Constructor
    public RiflesDeAsalto(int id_producto, String nombre, double precio, boolean disponibilidad, int daño, double alcance, int municion, String tipoMunicion, double cadencia, double precision, double peso) {
        super(id_producto, nombre, precio, disponibilidad, daño, alcance, municion, tipoMunicion, cadencia);
        this.precision = precision;
        this.peso = peso;
    }

    // Getters y Setters
    public double getPrecision() {
        return precision;
    }

    public void setPrecision(double precision) {
        this.precision = precision;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
