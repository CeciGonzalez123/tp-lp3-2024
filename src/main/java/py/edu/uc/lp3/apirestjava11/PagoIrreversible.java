package py.edu.uc.lp3.apirestjava11;

import java.util.Date;

public class PagoIrreversible extends Pago {
    public String tipoIrreversible;

    // Constructor
    public PagoIrreversible(double monto, Date fecha, String tipoIrreversible) {
        super(monto, fecha);
        this.tipoIrreversible = tipoIrreversible;
    }

    // Getters y Setters
    public String getTipoIrreversible() {
        return tipoIrreversible;
    }

    public void setTipoIrreversible(String tipoIrreversible) {
        this.tipoIrreversible = tipoIrreversible;
    }
}
