package py.edu.uc.lp3.apirestjava11;

import java.util.Date;

public class VentaDirecto extends Venta {
    public String medioPago;

    // Constructor
    public VentaDirecto(int idVenta, Date fecha, double montoTotal, String medioPago) {
        super(idVenta, fecha, montoTotal);
        this.medioPago = medioPago;
    }

    // Getters y Setters
    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }
}
