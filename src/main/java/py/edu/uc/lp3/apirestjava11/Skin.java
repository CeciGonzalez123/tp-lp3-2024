package py.edu.uc.lp3.apirestjava11;

public class Skin extends Accesorios {
    public String color;
    protected String rangoRaridad;

    // Constructor
    public Skin(int id_producto, String nombre, double precio, boolean disponibilidad, String color, String rangoRaridad) {
        super(id_producto, nombre, precio, disponibilidad, "TipoAccesorioDefault", "EfectoDefault"); // Pasa 6 argumentos
        this.color = color;
        this.rangoRaridad = rangoRaridad;
    }

    // Getters y Setters
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRangoRaridad() {
        return rangoRaridad;
    }

    public void setRangoRaridad(String rangoRaridad) {
        this.rangoRaridad = rangoRaridad;
    }
}
