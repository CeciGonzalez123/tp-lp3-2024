package py.edu.uc.lp3.response;

import java.util.List;

public class TotalPriceResponse {
    private List<DetalleCompraResponse> detalles;
    private double totalGeneral;

    // Getters y Setters
    public List<DetalleCompraResponse> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleCompraResponse> detalles) {
        this.detalles = detalles;
    }

    public double getTotalGeneral() {
        return totalGeneral;
    }

    public void setTotalGeneral(double totalGeneral) {
        this.totalGeneral = totalGeneral;
    }
}
