package cursos.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cursos.backend.entity.Cursos;
import cursos.backend.service.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private CursoService cursoService;

    @PostMapping("/registrarCurso")
    public Cursos crearCurso(@RequestBody Cursos curso, @RequestParam Long categoriaId) {
        return cursoService.crearCurso(curso, categoriaId);
    }

    @GetMapping("/listarCursos")
    public List<Cursos> listarCursos() {
        return cursoService.listarCursos();
    }

    @GetMapping("/obtenerCurso/{id}")
    public Cursos obtenerCurso(@PathVariable Long id) {
        return cursoService.obtenerCursoPorId(id);
    }

    @PutMapping("/actualizarCurso/{id}")
    public Cursos actualizarCurso(@PathVariable Long id, @RequestBody Cursos curso) {
        return cursoService.actualizarCurso(id, curso);
    }

    @DeleteMapping("/eliminarCurso/{id}")
    public void eliminarCurso(@PathVariable Long id) {
        cursoService.eliminarCurso(id);
    }
}

