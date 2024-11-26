package py.edu.uc.lp3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.edu.uc.lp3.domain.Producto;
import py.edu.uc.lp3.request.CompraProductoRequest;
import py.edu.uc.lp3.response.CompraProductoResponse;
import py.edu.uc.lp3.response.ProductoConArmaDTO;
import py.edu.uc.lp3.response.TotalPriceResponse;
import py.edu.uc.lp3.service.ProductoService;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private static final Logger logger = Logger.getLogger(ProductoController.class.getName());

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // Endpoint para crear múltiples productos en una sola solicitud (bulk insert)
    @PostMapping("/bulk-insert")
    public ResponseEntity<List<Producto>> bulkInsert(@RequestBody List<Producto> productos) {
        logger.info("Bulk insert de productos: " + productos);
        List<Producto> savedProductos = productoService.bulkInsert(productos);
        return new ResponseEntity<>(savedProductos, HttpStatus.CREATED);
    }

    @PostMapping("/comprar")
    public ResponseEntity<CompraProductoResponse> realizarCompra(@RequestBody CompraProductoRequest productosCompra) {
        logger.info("Realizando compra: " + productosCompra);
        CompraProductoResponse response = productoService.comprarProducto(productosCompra);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Endpoint para obtener un listado de todos los productos
    @GetMapping("/lista-productos")
    public ResponseEntity<List<Producto>> listarProductos() {
        logger.info("Listando todos los productos...");
        List<Producto> productos = productoService.obtenerTodosLosProductos();
        logger.info("Productos listados: " + productos);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    // Endpoint para calcular el precio total de los productos
    @PostMapping("/total-price")
    public ResponseEntity<TotalPriceResponse> calcularPrecioTotal(@RequestBody List<CompraProductoRequest> productosCompra) {
        logger.info("Calculando precio total de los productos: " + productosCompra);
        TotalPriceResponse totalPriceResponse = productoService.calcularPrecioTotal(productosCompra);
        return new ResponseEntity<>(totalPriceResponse, HttpStatus.OK);
    }

    // Endpoint para manejar la compra de un producto específico
    @PostMapping("/comprar-producto")
    public ResponseEntity<CompraProductoResponse> comprarProducto(@RequestBody CompraProductoRequest compraProductoRequest) {
        logger.info("Comprando producto: " + compraProductoRequest);
        CompraProductoResponse response = productoService.comprarProducto(compraProductoRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Endpoint para obtener productos con detalles de armas
    @GetMapping("/productos-con-armas")
    public ResponseEntity<List<ProductoConArmaDTO>> obtenerProductosConArmas() {
        logger.info("Obteniendo productos con detalles de armas...");
        List<ProductoConArmaDTO> productosConArmas = productoService.obtenerProductosConArmas();
        logger.info("Productos con armas obtenidos: " + productosConArmas);
        return new ResponseEntity<>(productosConArmas, HttpStatus.OK);
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        logger.info("Eliminando producto con ID: " + id);
        boolean eliminado = productoService.eliminarProducto(id); // Llama al método eliminarProducto del servicio
        if (eliminado) {
            return ResponseEntity.noContent().build(); // 204 No Content si fue eliminado
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found si no existe
        }
    }

}
