package py.edu.uc.lp3.apirestjava11;

import java.util.Date;

public class PagoReversible extends Pago {
    public String estadoReversion;

    // Constructor
    public PagoReversible(double monto, Date fecha, String estadoReversion) {
        super(monto, fecha);
        this.estadoReversion = estadoReversion;
    }

    // Getters y Setters
    public String getEstadoReversion() {
        return estadoReversion;
    }

    public void setEstadoReversion(String estadoReversion) {
        this.estadoReversion = estadoReversion;
    }
}
