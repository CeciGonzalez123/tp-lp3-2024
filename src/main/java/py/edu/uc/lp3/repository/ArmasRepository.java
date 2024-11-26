package py.edu.uc.lp3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import py.edu.uc.lp3.domain.Armas;

@Repository
public interface ArmasRepository extends CrudRepository<Armas, Long> {
}
