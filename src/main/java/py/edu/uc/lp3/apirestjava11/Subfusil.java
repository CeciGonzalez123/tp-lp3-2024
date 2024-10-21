package py.edu.uc.lp3.apirestjava11;

public class Subfusil extends ArmasDeFuego {
    public double retroceso;
    public double velocidadDisparo;

    // Constructor
    public Subfusil(int id_producto, String nombre, double precio, boolean disponibilidad, int daño, double alcance, int municion, String tipoMunicion, double cadencia, double retroceso, double velocidadDisparo) {
        super(id_producto, nombre, precio, disponibilidad, daño, alcance, municion, tipoMunicion, cadencia);
        this.retroceso = retroceso;
        this.velocidadDisparo = velocidadDisparo;
    }

    // Getters y Setters
    public double getRetroceso() {
        return retroceso;
    }

    public void setRetroceso(double retroceso) {
        this.retroceso = retroceso;
    }

    public double getVelocidadDisparo() {
        return velocidadDisparo;
    }

    public void setVelocidadDisparo(double velocidadDisparo) {
        this.velocidadDisparo = velocidadDisparo;
    }
}
