package py.edu.uc.lp3.domain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class prueba {

    @GetMapping("/hola")
    public String saludar() {
        return "Hola Mundo!";
    }
}

