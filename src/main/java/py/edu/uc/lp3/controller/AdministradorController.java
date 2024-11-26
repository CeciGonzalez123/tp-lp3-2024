package py.edu.uc.lp3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.edu.uc.lp3.domain.Administrador;
import py.edu.uc.lp3.service.AdministradorService;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/administradores")
public class AdministradorController {

    private static final Logger logger = Logger.getLogger(AdministradorController.class.getName());

    private final AdministradorService administradorService;

    @Autowired
    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    // Endpoint para obtener un listado de todos los administradores
    @GetMapping("/lista-administradores")
    public ResponseEntity<List<Administrador>> listarAdministradores() {
        logger.info("Listando todos los administradores...");
        List<Administrador> administradores = administradorService.obtenerTodosLosAdministradores();
        logger.info("Administradores listados: " + administradores);
        return new ResponseEntity<>(administradores, HttpStatus.OK);
    }

    // Endpoint para agregar un nuevo administrador
    @PostMapping("/agregar-administrador")
    public ResponseEntity<Administrador> agregarAdministrador(@RequestBody Administrador administrador) {
        logger.info("Agregando administrador: " + administrador);
        Administrador administradorGuardado = administradorService.guardarAdministrador(administrador);
        return new ResponseEntity<>(administradorGuardado, HttpStatus.CREATED);
    }
}
