package py.edu.uc.lp3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.edu.uc.lp3.domain.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Métodos adicionales si es necesario
}
