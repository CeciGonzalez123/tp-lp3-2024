package py.edu.uc.lp3.apirestjava11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final double MONTO_MINIMO_COMPRA = 50.00; // Ejemplo de monto mínimo

    // Crear el logger
    private static final Logger logger = LoggerFactory.getLogger(ProductoService.class);

    // Calcular el monto total de la compra
    public double calcularMontoTotal(List<Producto> productos) {
        double montoTotal = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .sum();

        // Log del monto total calculado
        logger.info("Monto total calculado: {}", montoTotal);

        return montoTotal;
    }

    // Validar si el total de la compra cumple con el monto mínimo
    public boolean validarMontoMinimoCompra(List<Producto> productos) {
        double montoTotal = calcularMontoTotal(productos);

        // Log del proceso de validación
        if (montoTotal >= MONTO_MINIMO_COMPRA) {
            logger.info("La compra cumple con el monto mínimo. Monto total: {}", montoTotal);
            return true;
        } else {
            logger.warn("La compra no cumple con el monto mínimo. Monto total: {}. Monto mínimo requerido: {}", montoTotal, MONTO_MINIMO_COMPRA);
            return false;
        }
    }

    // Obtener el monto mínimo configurado
    public double getMontoMinimoCompra() {
        return MONTO_MINIMO_COMPRA;
    }
}
