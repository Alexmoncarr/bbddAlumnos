package bbddAlumnos.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AlumnoController {
    private final AlumnoRepository repo;

    public AlumnoController(AlumnoRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("alumnos", repo.findAll());
        return "inicio";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("alumno", new Alumno());
        return "nuevo";
    }

    @PostMapping("/guardar")
    public String guardar(Alumno alumno) {
        repo.save(alumno);
        return "redirect:/";
    }
}
