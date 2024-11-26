package py.edu.uc.lp3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.edu.uc.lp3.domain.Armas;
import py.edu.uc.lp3.repository.ArmasRepository;
import py.edu.uc.lp3.repository.ProductoRepository;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ArmasService extends ProductoService {

    private static final Logger logger = Logger.getLogger(ArmasService.class.getName());

    private final ArmasRepository armasRepository;

    @Autowired
    public ArmasService(ArmasRepository armasRepository, ProductoRepository productoRepository) {
        super(productoRepository); // Llama al constructor de ProductoService
        this.armasRepository = armasRepository;
    }

    // Sobrescribir el método eliminarProducto para manejar específicamente armas
    @Override
    public boolean eliminarProducto(Long id) {
        logger.info("Intentando eliminar arma con ID: " + id);
        var armaOptional = armasRepository.findById(id);

        if (armaOptional.isPresent()) {
            armasRepository.delete(armaOptional.get());
            logger.info("Arma eliminada exitosamente.");
            return true;
        } else {
            logger.warning("Arma con ID " + id + " no encontrada.");
            return false;
        }
    }

    // Cambiar el nombre del método bulkInsert para evitar conflictos
    public List<Armas> bulkInsertArmas(List<Armas> armas) {
        logger.info("Insertando armas: " + armas);
        Iterable<Armas> resultadoIterable = armasRepository.saveAll(armas);
        // Conversión de Iterable a List
        return StreamSupport.stream(resultadoIterable.spliterator(), false)
                .collect(Collectors.toList());
    }


    // Método para obtener todas las armas con conversión adecuada de Iterable a List
    public List<Armas> obtenerTodasLasArmas() {
        logger.info("Obteniendo todas las armas...");
        Iterable<Armas> armasIterable = armasRepository.findAll();
        return StreamSupport.stream(armasIterable.spliterator(), false)
                .collect(Collectors.toList()); // Conversión de Iterable a List
    }
    public Armas obtenerArmaPorId(Long id) {
        logger.info("Obteniendo arma con ID: " + id);
        return armasRepository.findById(id).orElse(null); // Devuelve el arma si existe, o null si no
    }

}
