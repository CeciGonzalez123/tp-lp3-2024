package py.edu.uc.lp3.apirestjava11;

public class Emotes extends Animaciones {
    private String emocion;

    // Constructor
    public Emotes(int id_producto, String nombre, double precio, boolean disponibilidad, double duracion, String tipoAnimacion, String emocion) {
        super(id_producto, nombre, precio, disponibilidad, duracion, tipoAnimacion); // Llama al constructor de Animaciones
        this.emocion = emocion;
    }

    // Getter y Setter
    public String getEmocion() {
        return emocion;
    }

    public void setEmocion(String emocion) {
        this.emocion = emocion;
    }
}
