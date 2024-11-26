package py.edu.uc.lp3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.edu.uc.lp3.domain.Administrador;
import py.edu.uc.lp3.repository.AdministradorRepository;

import java.util.List;
import java.util.logging.Logger;

@Service
public class AdministradorService {

    private static final Logger logger = Logger.getLogger(AdministradorService.class.getName());

    private final AdministradorRepository administradorRepository;

    @Autowired
    public AdministradorService(AdministradorRepository administradorRepository) {
        this.administradorRepository = administradorRepository;
    }

    // Método para recuperar todos los administradores
    public List<Administrador> obtenerTodosLosAdministradores() {
        logger.info("Obteniendo todos los administradores...");
        List<Administrador> administradores = administradorRepository.findAll();
        logger.info("Administradores obtenidos: " + administradores);
        return administradores;
    }

    // Método para guardar un administrador
    public Administrador guardarAdministrador(Administrador administrador) {
        logger.info("Guardando administrador: " + administrador);
        return administradorRepository.save(administrador);
    }
}
