package py.edu.uc.lp3.apirestjava11;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // Validar si el listado de productos cumple con el monto mínimo de compra
    @PostMapping("/validar-compra")
    public ResponseEntity<String> validarCompra(@RequestBody(required = false) List<Producto> productos) {

        // Si la lista es nula o está vacía, se genera un mock de productos
        if (productos == null || productos.isEmpty()) {
            productos = generarProductosMock();
        }

        double montoTotal = productoService.calcularMontoTotal(productos);
        boolean cumpleCondicion = productoService.validarMontoMinimoCompra(productos);

        if (cumpleCondicion) {
            return ResponseEntity.ok("La compra cumple con el monto mínimo. Monto total: " + montoTotal);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("La compra no cumple con el monto mínimo de " + productoService.getMontoMinimoCompra() + ". Monto total: " + montoTotal);
        }
    }

    // Método para generar una lista de productos de ejemplo
    private List<Producto> generarProductosMock() {
        List<Producto> productosMock = new ArrayList<>();
        productosMock.add(new Producto(1, "Teclado Mock", 35.00, true));
        productosMock.add(new Producto(2, "Mouse Mock", 25.00, true));
        productosMock.add(new Producto(3, "Monitor Mock", 200.00, true));
        return productosMock;
    }
}
