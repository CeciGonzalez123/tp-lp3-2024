package py.edu.uc.lp3.apirestjava11;

public class Producto {
    private int id_producto;
    private String nombre;
    private double precio;
    private boolean disponibilidad;

    // Constructor con parámetros
    public Producto(int id_producto, String nombre, double precio, boolean disponibilidad) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
    }

    // Constructor sin parámetros (opcional, si quieres uno vacío)
    public Producto() {
        // Constructor vacío si es necesario
    }

    // Getters y Setters
    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
