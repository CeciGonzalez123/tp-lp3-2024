package py.edu.uc.lp3.apirestjava11;

public class Animaciones extends Accesorios {
    public double duracion;
    public String tipoAnimacion;

    // Constructor
    public Animaciones(int id_producto, String nombre, double precio, boolean disponibilidad, String tipoAccesorio, String efecto, double duracion, String tipoAnimacion) {
        super(id_producto, nombre, precio, disponibilidad, tipoAccesorio, efecto);
        this.duracion = duracion;
        this.tipoAnimacion = tipoAnimacion;
    }

    public Animaciones(int idProducto, String nombre, double precio, boolean disponibilidad, double duracion, String tipoAnimacion) {
        super();
    }

    // Getters y Setters
    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String getTipoAnimacion() {
        return tipoAnimacion;
    }

    public void setTipoAnimacion(String tipoAnimacion) {
        this.tipoAnimacion = tipoAnimacion;
    }
}
