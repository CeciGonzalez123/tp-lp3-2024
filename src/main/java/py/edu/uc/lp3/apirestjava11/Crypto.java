package py.edu.uc.lp3.apirestjava11;

import java.util.Date;

public class Crypto extends Digital {
    public String tipoMoneda;
    public String billeteraDestino;

    // Constructor
    public Crypto(double monto, Date fecha, String tipoIrreversible, String medioDigital, String tipoMoneda, String billeteraDestino) {
        super(monto, fecha, tipoIrreversible, medioDigital);
        this.tipoMoneda = tipoMoneda;
        this.billeteraDestino = billeteraDestino;
    }

    // Getters y Setters
    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public String getBilleteraDestino() {
        return billeteraDestino;
    }

    public void setBilleteraDestino(String billeteraDestino) {
        this.billeteraDestino = billeteraDestino;
    }
}
