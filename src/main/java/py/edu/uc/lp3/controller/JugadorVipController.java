package py.edu.uc.lp3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.edu.uc.lp3.domain.JugadorVip;
import py.edu.uc.lp3.service.JugadorService;

@RestController
@RequestMapping("/api/jugadores-vip")
public class JugadorVipController {

    private final JugadorService jugadorService;

    @Autowired
    public JugadorVipController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    // Endpoint para validar si un jugador VIP puede participar en el torneo
    @PostMapping("/validar-participacion")
    public ResponseEntity<String> validarParticipacion(@RequestBody JugadorVip jugador) {
        boolean puedeParticipar = jugadorService.puedeParticiparEnTorneo(jugador);

        if (puedeParticipar) {
            return ResponseEntity.ok("El jugador cumple con los requisitos para participar en el torneo.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El jugador no cumple con los requisitos mínimos para participar en el torneo.");
        }
    }

    // Endpoint para agregar un nuevo jugador VIP
    @PostMapping("/agregar-jugador-vip")
    public ResponseEntity<JugadorVip> agregarJugadorVip(@RequestBody JugadorVip jugador) {
        try {
            JugadorVip jugadorGuardado = (JugadorVip) jugadorService.guardarJugador(jugador);
            return new ResponseEntity<>(jugadorGuardado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
