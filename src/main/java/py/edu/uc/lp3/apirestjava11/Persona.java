package py.edu.uc.lp3.apirestjava11;
public class Persona {
    private int ci;
    protected String nombre;
    protected int edad;
    protected String email;

    // Constructor
    public Persona(int ci, String nombre, int edad, String email) {
        this.ci = ci;
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }

    // Getters y Setters
    public int getCi() {
        return ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
