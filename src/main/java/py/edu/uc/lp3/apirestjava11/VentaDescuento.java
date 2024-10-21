package py.edu.uc.lp3.apirestjava11;

import java.util.Date;

public class VentaDescuento extends VentaDirecto {
    public double porcentajeDescuento;
    public double montoDescuento;

    // Constructor
    public VentaDescuento(int idVenta, Date fecha, double montoTotal, String medioPago, double porcentajeDescuento, double montoDescuento) {
        super(idVenta, fecha, montoTotal, medioPago);
        this.porcentajeDescuento = porcentajeDescuento;
        this.montoDescuento = montoDescuento;
    }

    // Getters y Setters
    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public double getMontoDescuento() {
        return montoDescuento;
    }

    public void setMontoDescuento(double montoDescuento) {
        this.montoDescuento = montoDescuento;
    }
}
