package py.edu.uc.lp3.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Asegúrate de que esta anotación esté presente y configurada
    private long id;

    private String nombre;
    private String sexo;
    private String apellido;
    private Integer edad;
    private Integer numeroCedula;
    public static final String NACIONALIDAD = "Paraguayo";

    // Constructores
    public Persona() {}

    public Persona(String nombre, String apellido, Integer edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Persona(Integer numeroCedula, String nombre) {
        this.numeroCedula = numeroCedula;
        this.nombre = nombre;
    }

    public Persona(String nombre, String apellido, Integer edad, Integer numeroCedula) {
        this(nombre, apellido, edad);
        setNumeroCedula(numeroCedula);
    }

    // Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getNumeroCedula() {
        return numeroCedula;
    }

    public void setNumeroCedula(Integer numeroCedula) {
        this.numeroCedula = numeroCedula;
    }
}
