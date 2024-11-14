package py.edu.uc.lp3.response;

import java.util.List;

public class CompraResponse {
    private double total;
    private List<DetalleCompraResponse> detalles;

    // Getters y Setters
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<DetalleCompraResponse> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleCompraResponse> detalles) {
        this.detalles = detalles;
    }
}

