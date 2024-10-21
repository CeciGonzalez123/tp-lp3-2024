package py.edu.uc.lp3.apirestjava11;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private List<Producto> productos = new ArrayList<>();

    // Constructor con algunos productos de ejemplo
    public ProductoController() {
        productos.add(new Producto(1, "Teclado", 35.00, true));
        productos.add(new Producto(2, "Mouse", 25.00, true));
        productos.add(new Producto(3, "Monitor", 200.00, true));
    }

    // Obtener todos los productos
    @GetMapping
    public ResponseEntity<List<Producto>> getAllProductos() {
        return ResponseEntity.ok(productos);
    }

    // Obtener un producto por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable int id) {
        Optional<Producto> productoOpt = productos.stream()
                .filter(producto -> producto.getId_producto() == id)
                .findFirst();

        if (productoOpt.isPresent()) {
            return ResponseEntity.ok(productoOpt.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Agregar un nuevo producto
    @PostMapping
    public ResponseEntity<Producto> addProducto(@RequestBody Producto nuevoProducto) {
        productos.add(nuevoProducto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }

    // Actualizar un producto existente
    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable int id, @RequestBody Producto productoActualizado) {
        Optional<Producto> productoOpt = productos.stream()
                .filter(producto -> producto.getId_producto() == id)
                .findFirst();

        if (productoOpt.isPresent()) {
            Producto productoExistente = productoOpt.get();
            productoExistente.setNombre(productoActualizado.getNombre());
            productoExistente.setPrecio(productoActualizado.getPrecio());
            productoExistente.setDisponibilidad(productoActualizado.isDisponibilidad());
            return ResponseEntity.ok(productoExistente);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Eliminar un producto por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable int id) {
        boolean removed = productos.removeIf(producto -> producto.getId_producto() == id);

        if (removed) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
