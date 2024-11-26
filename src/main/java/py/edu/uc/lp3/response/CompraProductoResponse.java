package py.edu.uc.lp3.response;

import java.util.List;

public class CompraProductoResponse {
    private double total;
    private List<DetalleCompraResponse> detalles;
    private double precioTotal;
    private String mensaje;
    private List<String> productos;

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

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<String> getProductos() {
        return productos;
    }

    public void setProductos(List<String> productos) {
        this.productos = productos;
    }
}

