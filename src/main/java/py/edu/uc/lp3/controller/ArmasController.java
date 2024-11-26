package py.edu.uc.lp3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.edu.uc.lp3.domain.Armas;
import py.edu.uc.lp3.service.ArmasService;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/armas")
public class ArmasController {

    private static final Logger logger = Logger.getLogger(ArmasController.class.getName());

    private final ArmasService armasService;

    @Autowired
    public ArmasController(ArmasService armasService) {
        this.armasService = armasService;
    }

    // Endpoint para crear múltiples armas en una sola solicitud (bulk insert)
    @PostMapping("/bulk-insert")
    public ResponseEntity<List<Armas>> bulkInsert(@RequestBody List<Armas> armas) {
        logger.info("Bulk insert de armas: " + armas);
        List<Armas> savedArmas = armasService.bulkInsertArmas(armas);
        return new ResponseEntity<>(savedArmas, HttpStatus.CREATED);
    }


    // Endpoint para obtener un listado de todas las armas
    @GetMapping("/lista-armas")
    public ResponseEntity<List<Armas>> listarArmas() {
        logger.info("Listando todas las armas...");
        List<Armas> armas = armasService.obtenerTodasLasArmas();
        logger.info("Armas listadas: " + armas);
        return new ResponseEntity<>(armas, HttpStatus.OK);
    }
    // Endpoint para eliminar un arma por ID
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarArma(@PathVariable Long id) {
        logger.info("Eliminando arma con ID: " + id);
        boolean eliminado = armasService.eliminarProducto(id); // Llama al método eliminarProducto
        if (eliminado) {
            return ResponseEntity.noContent().build(); // 204 No Content si fue eliminado
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found si no existe
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Armas> obtenerArmaPorId(@PathVariable Long id) {
        logger.info("Buscando arma con ID: " + id);
        Armas arma = armasService.obtenerArmaPorId(id); // Llama al método del servicio
        if (arma != null) {
            return new ResponseEntity<>(arma, HttpStatus.OK); // Retorna el arma con estado 200 OK
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna 404 si no se encuentra
        }
    }


}
