package py.edu.uc.lp3.apirestjava11;

import java.util.Date;

public class Pago {
    public double monto;
    public Date fecha;

    // Constructor
    public Pago(double monto, Date fecha) {
        this.monto = monto;
        this.fecha = fecha;
    }

    // Getters y Setters
    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
