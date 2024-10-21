package py.edu.uc.lp3.apirestjava11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private static final Logger log = LoggerFactory.getLogger(PersonaController.class);

    // Lista estática de personas (datos ficticios para ejemplo)
    private static List<Persona> personas = new ArrayList<>();

    // Datos iniciales para prueba
    static {
        personas.add(new Persona(1, "Juan", 30, "juan.perez@example.com"));
        personas.add(new Persona(2, "María", 25, "maria.rodriguez@example.com"));
    }

    // Obtener todas las personas
    @GetMapping
    public ResponseEntity<List<Persona>> getAllPersonas() {
        log.info("Solicitando todas las personas");
        return ResponseEntity.ok(personas);
    }

    // Obtener persona por ID
    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable Long id) {
        log.info("Buscando persona con ID: {}", id);
        Optional<Persona> personaOpt = personas.stream()
                .filter(persona -> persona.getCi() == id)
                .findFirst();

        return personaOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Agregar una nueva persona
    @PostMapping
    public ResponseEntity<String> addPersona(@RequestBody Persona nuevaPersona) {
        log.info("Agregando nueva persona con CI: {}", nuevaPersona.getCi());
        personas.add(nuevaPersona);
        return ResponseEntity.ok("Persona agregada con éxito");
    }

    // Actualizar una persona existente
    @PutMapping("/{id}")
    public ResponseEntity<String> updatePersona(@PathVariable Long id, @RequestBody Persona personaActualizada) {
        log.info("Actualizando persona con ID: {}", id);
        Optional<Persona> personaOpt = personas.stream()
                .filter(persona -> persona.getCi() == id)
                .findFirst();

        if (personaOpt.isPresent()) {
            Persona persona = personaOpt.get();
            persona.setNombre(personaActualizada.getNombre());
            persona.setEdad(personaActualizada.getEdad());
            persona.setEmail(personaActualizada.getEmail());
            return ResponseEntity.ok("Persona actualizada con éxito");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una persona por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersona(@PathVariable Long id) {
        log.info("Eliminando persona con ID: {}", id);
        Optional<Persona> personaOpt = personas.stream()
                .filter(persona -> persona.getCi() == id)
                .findFirst();

        if (personaOpt.isPresent()) {
            personas.remove(personaOpt.get());
            return ResponseEntity.ok("Persona eliminada con éxito");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
