package py.edu.uc.lp3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.edu.uc.lp3.domain.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
}
