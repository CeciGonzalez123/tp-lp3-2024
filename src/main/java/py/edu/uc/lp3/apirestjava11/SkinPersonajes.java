package py.edu.uc.lp3.apirestjava11;

public class SkinPersonajes extends Skin {
    public String traje;
    public boolean animacionesEspeciales;

    // Constructor
    public SkinPersonajes(int id_producto, String nombre, double precio, boolean disponibilidad, String color, String rangoRaridad, String traje, boolean animacionesEspeciales) {
        super(id_producto, nombre, precio, disponibilidad, color, rangoRaridad);
        this.traje = traje;
        this.animacionesEspeciales = animacionesEspeciales;
    }

    // Getters y Setters
    public String getTraje() {
        return traje;
    }

    public void setTraje(String traje) {
        this.traje = traje;
    }

    public boolean isAnimacionesEspeciales() {
        return animacionesEspeciales;
    }

    public void setAnimacionesEspeciales(boolean animacionesEspeciales) {
        this.animacionesEspeciales = animacionesEspeciales;
    }
}
