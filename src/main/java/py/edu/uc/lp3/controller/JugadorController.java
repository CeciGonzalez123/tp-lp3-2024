package py.edu.uc.lp3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.edu.uc.lp3.domain.Jugador;
import py.edu.uc.lp3.domain.JugadorPromedio;
import py.edu.uc.lp3.domain.JugadorVip;
import py.edu.uc.lp3.service.JugadorService;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {

    private static final Logger logger = Logger.getLogger(JugadorController.class.getName());

    private final JugadorService jugadorService;

    @Autowired
    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    // Endpoint para obtener un listado de todos los jugadores
    @GetMapping("/lista-jugadores")
    public ResponseEntity<List<Jugador>> listarJugadores() {
        try {
            logger.info("Listando todos los jugadores...");
            List<Jugador> jugadores = jugadorService.obtenerTodosLosJugadores();
            logger.info("Jugadores listados: " + jugadores);
            return new ResponseEntity<>(jugadores, HttpStatus.OK);
        } catch (Exception e) {
            logger.severe("Error al listar los jugadores: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para agregar un nuevo jugador
    @PostMapping("/agregar-jugador")
    public ResponseEntity<Jugador> agregarJugador(@RequestBody Jugador jugador) {
        try {
            logger.info("Agregando jugador: " + jugador);
            Jugador jugadorGuardado = jugadorService.guardarJugador(jugador);
            return new ResponseEntity<>(jugadorGuardado, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.severe("Error al agregar el jugador: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // Endpoint para eliminar un jugador por ID
    @DeleteMapping("/eliminar-jugador/{id}")
    public ResponseEntity<Void> eliminarJugador(@PathVariable Long id) {
        try {
            logger.info("Eliminando jugador con ID: " + id);
            boolean eliminado = jugadorService.deletePersona(id);
            if (eliminado) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.severe("Error al eliminar el jugador: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // Endpoint para validar si un jugador puede participar en el torneo
    @GetMapping("/puede-participar/{id}")
    public ResponseEntity<Boolean> validarParticipacion(@PathVariable Long id) {
        try {
            logger.info("Validando participación del jugador con ID: " + id);
            Jugador jugador = (Jugador) jugadorService.getPersonaById(id); // Si tienes lógica específica para obtener jugadores
            if (jugador == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            // Validar según el tipo de jugador
            if (jugador instanceof JugadorPromedio) {
                return new ResponseEntity<>(jugadorService.puedeParticiparEnTorneo((JugadorPromedio) jugador), HttpStatus.OK);
            } else if (jugador instanceof JugadorVip) {
                return new ResponseEntity<>(jugadorService.puedeParticiparEnTorneo((JugadorVip) jugador), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            logger.severe("Error al validar participación: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Jugador> obtenerJugadorPorId(@PathVariable Long id) {
        logger.info("Buscando jugador con ID: " + id);
        Jugador jugador = jugadorService.obtenerJugadorPorId(id); // Llama al método del servicio
        if (jugador != null) {
            return new ResponseEntity<>(jugador, HttpStatus.OK); // Retorna el jugador con estado 200 OK
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna 404 si no se encuentra
        }
    }



}
