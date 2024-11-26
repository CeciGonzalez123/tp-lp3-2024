package py.edu.uc.lp3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.edu.uc.lp3.domain.Usuario;
import py.edu.uc.lp3.repository.UsuarioRepository;

import java.util.List;
import java.util.logging.Logger;

@Service
public class UsuarioService {

    private static final Logger logger = Logger.getLogger(UsuarioService.class.getName());

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Método para recuperar todos los usuarios
    public List<Usuario> obtenerTodosLosUsuarios() {
        logger.info("Obteniendo todos los usuarios...");
        List<Usuario> usuarios = usuarioRepository.findAll();
        logger.info("Usuarios obtenidos: " + usuarios);
        return usuarios;
    }

    // Método para guardar un usuario
    public Usuario guardarUsuario(Usuario usuario) {
        logger.info("Guardando usuario: " + usuario);
        return usuarioRepository.save(usuario);
    }
}
