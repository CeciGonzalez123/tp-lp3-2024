package py.edu.uc.lp3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.edu.uc.lp3.domain.Producto;
import py.edu.uc.lp3.repository.ProductoRepository;
import py.edu.uc.lp3.request.CompraProductoRequest;
import py.edu.uc.lp3.response.CompraResponse;
import py.edu.uc.lp3.response.DetalleCompraResponse;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // Método para insertar múltiples productos en una sola operación
    public List<Producto> bulkInsert(List<Producto> productos) {
        return productoRepository.saveAll(productos);
    }

    // Método para procesar la compra de productos
    public CompraResponse procesarCompra(List<CompraProductoRequest> productosCompra) {
        List<DetalleCompraResponse> detalles = new ArrayList<>();
        double total = 0;

        for (CompraProductoRequest compra : productosCompra) {
            Producto producto = productoRepository.findById(compra.getId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            double subtotal = producto.getPrecio() * compra.getCantidad();
            total += subtotal;

            DetalleCompraResponse detalle = new DetalleCompraResponse();
            detalle.setNombre(producto.getNombre());
            detalle.setCantidad(compra.getCantidad());
            detalle.setPrecioUnitario(producto.getPrecio());
            detalle.setSubtotal(subtotal);

            detalles.add(detalle);
        }

        CompraResponse response = new CompraResponse();
        response.setDetalles(detalles);
        response.setTotal(total);

        return response;
    }
}
