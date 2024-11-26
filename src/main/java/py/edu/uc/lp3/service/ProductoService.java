package py.edu.uc.lp3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.edu.uc.lp3.domain.Producto;
import py.edu.uc.lp3.repository.ProductoRepository;
import py.edu.uc.lp3.request.CompraProductoRequest;
import py.edu.uc.lp3.response.CompraProductoResponse;
import py.edu.uc.lp3.response.DetalleCompraResponse;
import py.edu.uc.lp3.response.TotalPriceResponse;
import py.edu.uc.lp3.response.ProductoConArmaDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class ProductoService {

    private static final Logger logger = Logger.getLogger(ProductoService.class.getName());

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // Método para insertar múltiples productos en una sola operación
    public List<Producto> bulkInsert(List<Producto> productos) {
        logger.info("Insertando productos: " + productos);
        return productoRepository.saveAll(productos);
    }

    // Método para procesar la compra de productos
    public CompraProductoResponse comprarProducto(CompraProductoRequest compraProductoRequest) {
        logger.info("Comprando producto: " + compraProductoRequest);
        Producto producto = productoRepository.findById(compraProductoRequest.getId())
                .orElseThrow(() -> {
                    logger.severe("Producto no encontrado: " + compraProductoRequest.getId());
                    return new RuntimeException("Producto no encontrado");
                });

        double precioTotal = producto.getPrecio() * compraProductoRequest.getCantidad();
        String mensaje = "Compra realizada exitosamente.";

        DetalleCompraResponse detalle = new DetalleCompraResponse();
        detalle.setNombre(producto.getNombre());
        detalle.setCantidad(compraProductoRequest.getCantidad());
        detalle.setPrecioUnitario(producto.getPrecio());
        detalle.setSubtotal(precioTotal);

        CompraProductoResponse response = new CompraProductoResponse();
        response.setTotal(precioTotal); // Establecer el total
        response.setPrecioTotal(precioTotal); // Establecer el precio total
        response.setMensaje(mensaje); // Establecer el mensaje
        response.setDetalles(List.of(detalle)); // Establecer los detalles de la compra
        response.setProductos(List.of(producto.getNombre())); // Establecer los productos comprados
        logger.info("Producto comprado: " + response);

        return response;
    }

    // Método para calcular el precio total de los productos
    public TotalPriceResponse calcularPrecioTotal(List<CompraProductoRequest> productosCompra) {
        logger.info("Calculando el precio total de los productos...");
        List<DetalleCompraResponse> detalles = new ArrayList<>();
        double totalGeneral = 0;

        for (CompraProductoRequest compra : productosCompra) {
            Producto producto = productoRepository.findById(compra.getId())
                    .orElseThrow(() -> {
                        logger.severe("Producto no encontrado: " + compra.getId());
                        return new RuntimeException("Producto no encontrado");
                    });

            double total = producto.getPrecio() * compra.getCantidad();
            totalGeneral += total;

            DetalleCompraResponse detalle = new DetalleCompraResponse();
            detalle.setNombre(producto.getNombre());
            detalle.setCantidad(compra.getCantidad());
            detalle.setPrecioUnitario(producto.getPrecio());
            detalle.setSubtotal(total);

            detalles.add(detalle);
        }

        TotalPriceResponse response = new TotalPriceResponse();
        response.setDetalles(detalles);
        response.setTotalGeneral(totalGeneral);
        logger.info("Precio total calculado: " + response);

        return response;
    }

    // Método para recuperar todos los productos desde la base de datos
    public List<Producto> obtenerTodosLosProductos() {
        logger.info("Obteniendo todos los productos...");
        List<Producto> productos = productoRepository.findAll();
        logger.info("Productos obtenidos: " + productos);
        return productos;
    }

    // Método para obtener productos con detalles de armas
    public List<ProductoConArmaDTO> obtenerProductosConArmas() {
        logger.info("Obteniendo productos con detalles de armas...");
        List<ProductoConArmaDTO> productosConArmas = productoRepository.findProductosConArmas();
        logger.info("Productos con armas obtenidos: " + productosConArmas);
        return productosConArmas;
    }
    // Método para eliminar un producto por su ID
    public boolean eliminarProducto(Long id) {
        logger.info("Intentando eliminar producto con ID: " + id);
        var productoOptional = productoRepository.findById(id);

        if (productoOptional.isPresent()) {
            productoRepository.delete(productoOptional.get());
            logger.info("Producto eliminado exitosamente.");
            return true;
        } else {
            logger.warning("Producto con ID " + id + " no encontrado.");
            return false;
        }
    }

}