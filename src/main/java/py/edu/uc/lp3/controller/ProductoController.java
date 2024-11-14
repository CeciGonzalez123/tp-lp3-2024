package py.edu.uc.lp3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import py.edu.uc.lp3.domain.Producto;
import py.edu.uc.lp3.request.CompraProductoRequest;
import py.edu.uc.lp3.response.CompraResponse;
import py.edu.uc.lp3.service.ProductoService;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // Endpoint para crear múltiples productos en una sola solicitud (bulk insert)
    @PostMapping("/bulk-insert")
    public ResponseEntity<List<Producto>> bulkInsert(@RequestBody List<Producto> productos) {
        List<Producto> savedProductos = productoService.bulkInsert(productos);
        return new ResponseEntity<>(savedProductos, HttpStatus.CREATED);
    }
    @PostMapping("/comprar")
    public CompraResponse realizarCompra(@RequestBody List<CompraProductoRequest> productosCompra) {
        return productoService.procesarCompra(productosCompra);
    }


    // Otros métodos CRUD pueden agregarse aquí si son necesarios
}

