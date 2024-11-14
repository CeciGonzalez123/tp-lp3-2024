package py.edu.uc.lp3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import py.edu.uc.lp3.domain.Persona;
import py.edu.uc.lp3.service.PersonaService;

import java.util.List;

@RestController
@RequestMapping("/api/persona") // Base URL para todos los endpoints de persona
public class PersonaController {

    private final PersonaService personaService;

    @Autowired
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    // Endpoint para realizar una acción con la información de una persona
    @PostMapping
    public String realizarAccion(@RequestBody(required = false) Persona persona) {
        if (persona == null) {
            return "Error: No se ha proporcionado información de la persona.";
        }
        if (!personaService.esMayorDeEdad(persona.getEdad())) {
            return "Debes tener al menos 18 años para comprar o trabajar en la tienda.";
        }
        return "Acción realizada con éxito";
    }

    // Endpoint para agregar una lista de personas en una sola llamada
    @PostMapping("/bulk")
    public void addBulk(@RequestBody List<py.edu.uc.lp3.domain.Persona> personas) {
        personaService.saveList(personas);
    }

    // Endpoint para obtener todas las personas
    @GetMapping
    public List<Persona> getAllPersonas() {
        return personaService.getAllPersonas();
    }

    // Endpoint para obtener una persona por su ID
    @GetMapping("/{id}")
    public Persona getPersonaById(@PathVariable Long id) {
        return personaService.getPersonaById(id);
    }

    // Endpoint para actualizar una persona por su ID
    @PutMapping("/{id}")
    public String updatePersona(@PathVariable Long id, @RequestBody Persona persona) {
        Persona updatedPersona = personaService.updatePersona(id, persona);
        if (updatedPersona == null) {
            return "Error: Persona no encontrada.";
        }
        return "Persona actualizada con éxito.";
    }

    // Endpoint para eliminar una persona por su ID
    @DeleteMapping("/{id}")
    public String deletePersona(@PathVariable Long id) {
        boolean deleted = personaService.deletePersona(id);
        return deleted ? "Persona eliminada con éxito." : "Error: Persona no encontrada.";
    }
}