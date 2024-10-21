package py.edu.uc.lp3.apirestjava11;

import java.util.Date;

public class Tarjeta extends Digital {
    public String numeroTarjeta;
    public String titularTarjeta;

    // Constructor
    public Tarjeta(double monto, Date fecha, String tipoIrreversible, String medioDigital, String numeroTarjeta, String titularTarjeta) {
        super(monto, fecha, tipoIrreversible, medioDigital);
        this.numeroTarjeta = numeroTarjeta;
        this.titularTarjeta = titularTarjeta;
    }

    // Getters y Setters
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getTitularTarjeta() {
        return titularTarjeta;
    }

    public void setTitularTarjeta(String titularTarjeta) {
        this.titularTarjeta = titularTarjeta;
    }
}

