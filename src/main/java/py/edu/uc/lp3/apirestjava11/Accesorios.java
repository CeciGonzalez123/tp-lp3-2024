package py.edu.uc.lp3.apirestjava11;

import py.edu.uc.lp3.apirestjava11.Producto;

public class Accesorios extends Producto {
    private String tipoAccesorio;
    private String efecto;

    // Constructor con parámetros
    public Accesorios(int id_producto, String nombre, double precio, boolean disponibilidad, String tipoAccesorio, String efecto) {
        super(id_producto, nombre, precio, disponibilidad); // Llama al constructor de Producto
        this.tipoAccesorio = tipoAccesorio;
        this.efecto = efecto;
    }

    public Accesorios() {

    }

    // Getters y Setters
    public String getTipoAccesorio() {
        return tipoAccesorio;
    }

    public void setTipoAccesorio(String tipoAccesorio) {
        this.tipoAccesorio = tipoAccesorio;
    }

    public String getEfecto() {
        return efecto;
    }

    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }
}
