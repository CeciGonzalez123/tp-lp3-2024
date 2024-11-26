package py.edu.uc.lp3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.edu.uc.lp3.domain.Jugador;
import py.edu.uc.lp3.domain.JugadorPromedio;
import py.edu.uc.lp3.domain.JugadorVip;
import py.edu.uc.lp3.repository.JugadorRepository;

import java.util.Optional;
import java.util.List;
import java.util.logging.Logger;

@Service
public class JugadorService extends PersonaService {

    private static final Logger logger = Logger.getLogger(JugadorService.class.getName());

    private final JugadorRepository jugadorRepository;

    @Autowired
    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    @Override
    public boolean deletePersona(Long id) {
        logger.info("Intentando eliminar jugador con ID: " + id);

        Optional<Jugador> jugadorOptional = jugadorRepository.findById(id);
        if (jugadorOptional.isPresent()) {
            jugadorRepository.delete(jugadorOptional.get());
            logger.info("Jugador eliminado exitosamente.");
            return true;
        } else {
            logger.warning("Jugador con ID " + id + " no encontrado.");
            return false;
        }
    }

    // Método para recuperar todos los jugadores
    public List<Jugador> obtenerTodosLosJugadores() {
        logger.info("Obteniendo todos los jugadores...");
        return jugadorRepository.findAll();
    }

    // Método para guardar un jugador
    public Jugador guardarJugador(Jugador jugador) {
        logger.info("Guardando jugador: " + jugador);
        return jugadorRepository.save(jugador);
    }

    // Método para validar si un jugador promedio puede participar en el torneo
    public boolean puedeParticiparEnTorneo(JugadorPromedio jugador) {
        return jugador.getNivel() >= 5 && jugador.getPuntos() >= 1000;
    }

    // Método para validar si un jugador VIP puede participar en el torneo
    public boolean puedeParticiparEnTorneo(JugadorVip jugador) {
        return jugador.getNivel() >= 5 && jugador.getPuntos() >= 1000 && jugador.isVip();
    }
    public Jugador obtenerJugadorPorId(Long id) {
        logger.info("Obteniendo jugador con ID: " + id);
        return jugadorRepository.findById(id).orElse(null); // Devuelve el jugador si existe, o null si no
    }

}
