package py.edu.uc.lp3.apirestjava11;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    private final JugadorService jugadorService;

    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    // Endpoint para validar si el jugador puede participar en el torneo
    @PostMapping("/validar-participacion")
    public ResponseEntity<String> validarParticipacion(@RequestBody Jugador jugador) {
        boolean puedeParticipar = jugadorService.puedeParticiparEnTorneo(jugador);

        if (puedeParticipar) {
            return ResponseEntity.ok("El jugador cumple con los requisitos para participar en el torneo.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El jugador no cumple con los requisitos mínimos para participar en el torneo.");
        }
    }
}
