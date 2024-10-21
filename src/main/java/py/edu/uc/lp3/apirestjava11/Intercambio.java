package py.edu.uc.lp3.apirestjava11;

import java.util.Date;

public class Intercambio extends Venta {
    public String articuloIntercambiado;
    public double valorEstimado;

    // Constructor
    public Intercambio(int idVenta, Date fecha, double montoTotal, String articuloIntercambiado, double valorEstimado) {
        super(idVenta, fecha, montoTotal);
        this.articuloIntercambiado = articuloIntercambiado;
        this.valorEstimado = valorEstimado;
    }

    // Getters y Setters
    public String getArticuloIntercambiado() {
        return articuloIntercambiado;
    }

    public void setArticuloIntercambiado(String articuloIntercambiado) {
        this.articuloIntercambiado = articuloIntercambiado;
    }

    public double getValorEstimado() {
        return valorEstimado;
    }

    public void setValorEstimado(double valorEstimado) {
        this.valorEstimado = valorEstimado;
    }
}
