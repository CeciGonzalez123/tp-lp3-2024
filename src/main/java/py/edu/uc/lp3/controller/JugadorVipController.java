package py.edu.uc.lp3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.edu.uc.lp3.service.JugadorService;
import py.edu.uc.lp3.domain.JugadorVip;

@RestController
@RequestMapping("/jugadores/vip")
public class JugadorVipController {

    private final JugadorService jugadorService;

    @Autowired
    public JugadorVipController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    // Endpoint para validar si un JugadorVip puede participar en un torneo
    @PostMapping("/validar-participacion")
    public ResponseEntity<String> validarParticipacion(@RequestBody JugadorVip jugadorVip) {
        boolean puedeParticipar = jugadorService.puedeParticiparEnTorneo(jugadorVip);

        if (puedeParticipar && jugadorVip.isSuscripcionActiva()) {
            return ResponseEntity.ok("El Jugador VIP cumple con los requisitos para participar en el torneo.");
        } else {
            String mensaje = !puedeParticipar ? "El Jugador VIP no cumple con los requisitos de nivel o puntos. "
                    : "El Jugador VIP no tiene una suscripción activa.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensaje);
        }
    }
}
