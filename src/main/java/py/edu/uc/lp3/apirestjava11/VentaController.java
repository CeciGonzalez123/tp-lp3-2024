package py.edu.uc.lp3.apirestjava11;

import org.springframework.web.bind.annotation.*;
import py.edu.uc.lp3.apirestjava11.Venta;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    private List<Venta> ventas = new ArrayList<>();

    // Método para obtener todas las ventas
    @GetMapping
    public List<Venta> getAllVentas() {
        return ventas;
    }

    // Método para obtener una venta por id
    @GetMapping("/{id}")
    public Venta getVentaById(@PathVariable int id) {
        return ventas.stream()
                .filter(venta -> venta.getIdVenta() == id)
                .findFirst()
                .orElse(null);
    }

    // Método para crear una nueva venta
    @PostMapping
    public Venta createVenta(@RequestBody Venta venta) {
        ventas.add(venta);
        return venta;
    }

    // Método para actualizar una venta existente
    @PutMapping("/{id}")
    public Venta updateVenta(@PathVariable int id, @RequestBody Venta ventaDetails) {
        Venta venta = ventas.stream()
                .filter(v -> v.getIdVenta() == id)
                .findFirst()
                .orElse(null);

        if (venta != null) {
            venta.setFecha(ventaDetails.getFecha());
            venta.setMontoTotal(ventaDetails.getMontoTotal());
        }

        return venta;
    }

    // Método para eliminar una venta por id
    @DeleteMapping("/{id}")
    public String deleteVenta(@PathVariable int id) {
        boolean removed = ventas.removeIf(venta -> venta.getIdVenta() == id);

        if (removed) {
            return "Venta eliminada exitosamente.";
        } else {
            return "Venta no encontrada.";
        }
    }
}
