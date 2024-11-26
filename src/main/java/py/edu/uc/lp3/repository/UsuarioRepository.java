package py.edu.uc.lp3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.edu.uc.lp3.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
