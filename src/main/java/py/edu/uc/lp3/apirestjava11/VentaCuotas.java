package py.edu.uc.lp3.apirestjava11;

import java.util.Date;

public class VentaCuotas extends VentaDirecto {
    public int numeroCuotas;
    public double montoPorCuota;
    public double interes;

    // Constructor
    public VentaCuotas(int idVenta, Date fecha, double montoTotal, String medioPago, int numeroCuotas, double montoPorCuota, double interes) {
        super(idVenta, fecha, montoTotal, medioPago);
        this.numeroCuotas = numeroCuotas;
        this.montoPorCuota = montoPorCuota;
        this.interes = interes;
    }

    // Getters y Setters
    public int getNumeroCuotas() {
        return numeroCuotas;
    }

    public void setNumeroCuotas(int numeroCuotas) {
        this.numeroCuotas = numeroCuotas;
    }

    public double getMontoPorCuota() {
        return montoPorCuota;
    }

    public void setMontoPorCuota(double montoPorCuota) {
        this.montoPorCuota = montoPorCuota;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }
}
