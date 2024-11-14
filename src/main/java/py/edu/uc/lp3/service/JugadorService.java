package py.edu.uc.lp3.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import py.edu.uc.lp3.domain.Jugador;

@Service
public class JugadorService {

    private static final Logger logger = LoggerFactory.getLogger(JugadorService.class);
    private static final int NIVEL_MINIMO = 5;
    private static final int PUNTOS_MINIMOS = 1000;

    // Validación de si un jugador puede participar en un torneo
    public boolean puedeParticiparEnTorneo(Jugador jugador) {
        boolean cumpleNivel = jugador.getNivel() >= NIVEL_MINIMO;
        boolean cumplePuntos = jugador.getPuntos() >= PUNTOS_MINIMOS;

        // Log de validación
        if (cumpleNivel && cumplePuntos) {
            logger.info("El jugador cumple con los requisitos para participar en el torneo.");
            return true;
        } else {
            if (!cumpleNivel) {
                logger.warn("El jugador no cumple con el nivel mínimo requerido: {}", NIVEL_MINIMO);
            }
            if (!cumplePuntos) {
                logger.warn("El jugador no cumple con los puntos mínimos requeridos: {}", PUNTOS_MINIMOS);
            }
            return false;
        }
    }
}

