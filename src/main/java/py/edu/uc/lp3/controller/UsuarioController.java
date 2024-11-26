package py.edu.uc.lp3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.edu.uc.lp3.domain.Usuario;
import py.edu.uc.lp3.service.UsuarioService;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private static final Logger logger = Logger.getLogger(UsuarioController.class.getName());

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Endpoint para obtener un listado de todos los usuarios
    @GetMapping("/lista-usuarios")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        logger.info("Listando todos los usuarios...");
        List<Usuario> usuarios = usuarioService.obtenerTodosLosUsuarios();
        logger.info("Usuarios listados: " + usuarios);
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    // Endpoint para agregar un nuevo usuario
    @PostMapping("/agregar-usuario")
    public ResponseEntity<Usuario> agregarUsuario(@RequestBody Usuario usuario) {
        logger.info("Agregando usuario: " + usuario);
        Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario);
        return new ResponseEntity<>(usuarioGuardado, HttpStatus.CREATED);
    }
}
