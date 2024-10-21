package py.edu.uc.lp3.apirestjava11;

public class Melee extends Armas {
    public String material;
    public double longitud;

    // Constructor
    public Melee(int id_producto, String nombre, double precio, boolean disponibilidad, int daño, double alcance, int municion, String material, double longitud) {
        super(id_producto, nombre, precio, disponibilidad, daño, alcance, municion);
        this.material = material;
        this.longitud = longitud;
    }

    // Getters y Setters
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}
