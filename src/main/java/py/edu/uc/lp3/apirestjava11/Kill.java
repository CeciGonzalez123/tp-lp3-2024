package py.edu.uc.lp3.apirestjava11;

public class Kill extends Animaciones {
    private String tipoEfecto;

    // Constructor
    public Kill(int id_producto, String nombre, double precio, boolean disponibilidad, double duracion, String tipoAnimacion, String tipoEfecto) {
        super(id_producto, nombre, precio, disponibilidad, duracion, tipoAnimacion); // Llama al constructor de Animaciones
        this.tipoEfecto = tipoEfecto;
    }

    // Getter y Setter
    public String getTipoEfecto() {
        return tipoEfecto;
    }

    public void setTipoEfecto(String tipoEfecto) {
        this.tipoEfecto = tipoEfecto;
    }
}
