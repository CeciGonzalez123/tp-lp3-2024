package py.edu.uc.lp3.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.edu.uc.lp3.domain.Persona;
import py.edu.uc.lp3.repository.PersonaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    private static final Logger logger = LoggerFactory.getLogger(PersonaService.class);
    private final List<Persona> personas = new ArrayList<>();
    private static final int EDAD_MINIMA_MAYORIA_EDAD = 18;

    // Método para validar individualmente si una persona es mayor de edad
    public boolean esMayorDeEdad(int edad) {
        boolean esMayor = edad >= EDAD_MINIMA_MAYORIA_EDAD;
        logger.info("Validación de edad: {} años. Resultado: {}", edad, esMayor ? "Mayor de edad" : "Menor de edad");
        return esMayor;
    }

    // Método para recuperar todas las personas
    public List<Persona> getAllPersonas() {
        logger.info("Recuperando todas las personas");
        return personas;
    }

    // Método para obtener una persona por su ID
    public Persona getPersonaById(Long id) {
        logger.info("Buscando persona con ID: {}", id);
        Optional<Persona> persona = personas.stream().filter(e -> e.getId()==id).findFirst();
        return persona.orElse(null);
    }

    // Método para guardar una nueva persona
    public Persona savePersona(Persona persona) {
        logger.info("Guardando nueva persona: {}", persona);
        personas.add(persona);
        return persona;
    }

    // Método para actualizar una persona existente
    public Persona updatePersona(Long id, Persona personaActualizada) {
        Persona personaExistente = getPersonaById(id);
        if (personaExistente != null) {
            logger.info("Actualizando persona con ID: {}", id);
            personaExistente.setNombre(personaActualizada.getNombre());
            personaExistente.setApellido(personaActualizada.getApellido());
            personaExistente.setNumeroCedula(personaActualizada.getNumeroCedula());
            personaExistente.setEdad(personaActualizada.getEdad());
            return personaExistente;
        } else {
            logger.warn("Persona con ID: {} no encontrada", id);
            return null;
        }
    }

    // Método para eliminar una persona por su ID
    public boolean deletePersona(Long id) {
        logger.info("Eliminando persona con ID: {}", id);
        return personas.removeIf(e -> e.getId()==id);
    }

    // Método para guardar una lista de personas en el repositorio
    public void saveList(List<py.edu.uc.lp3.domain.Persona> personas) {
        for (py.edu.uc.lp3.domain.Persona aGuardar : personas) {
            save(aGuardar);
        }
    }

    // Método para guardar una persona en el repositorio
    public void save(py.edu.uc.lp3.domain.Persona persona) {
        personaRepository.save(persona);
    }
}

