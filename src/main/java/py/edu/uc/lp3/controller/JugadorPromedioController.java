package py.edu.uc.lp3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.edu.uc.lp3.service.JugadorService;
import py.edu.uc.lp3.domain.JugadorPromedio;

@RestController
@RequestMapping("/jugadores/promedio")
public class JugadorPromedioController {

    private final JugadorService jugadorService;

    @Autowired
    public JugadorPromedioController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    // Endpoint para validar si un JugadorPromedio puede participar en un torneo
    @PostMapping("/validar-participacion")
    public ResponseEntity<String> validarParticipacion(@RequestBody JugadorPromedio jugadorPromedio) {
        boolean puedeParticipar = jugadorService.puedeParticiparEnTorneo(jugadorPromedio);

        if (puedeParticipar && jugadorPromedio.getNumPartidasJugadas() > 10) {
            return ResponseEntity.ok("El Jugador Promedio cumple con los requisitos para participar en el torneo.");
        } else {
            String mensaje = !puedeParticipar ? "El Jugador Promedio no cumple con los requisitos de nivel o puntos. "
                    : "El Jugador Promedio no ha jugado suficientes partidas.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensaje);
        }
    }
}
