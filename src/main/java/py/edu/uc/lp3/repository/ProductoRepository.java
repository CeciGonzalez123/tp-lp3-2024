package py.edu.uc.lp3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import py.edu.uc.lp3.domain.Producto;
import py.edu.uc.lp3.response.ProductoConArmaDTO;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Consulta personalizada para combinar productos y armas
    @Query("SELECT new py.edu.uc.lp3.response.ProductoConArmaDTO(p.id, p.nombre, p.precio, p.disponibilidad, " +
            "a.daño, a.alcance, a.municion) " +
            "FROM Producto p JOIN Armas a ON p.id = a.id")
    List<ProductoConArmaDTO> findProductosConArmas();
}
