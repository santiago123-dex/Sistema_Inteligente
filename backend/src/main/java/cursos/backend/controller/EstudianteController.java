package cursos.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cursos.backend.dto.estudiantes.EstudianteRequest;
import cursos.backend.dto.estudiantes.EstudianteResponse;
import cursos.backend.service.EstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService){
        this.estudianteService = estudianteService;
    }

    @PostMapping("/registrarEstudiante")
    public ResponseEntity<EstudianteResponse> registrar(@RequestBody EstudianteRequest request){
        return ResponseEntity.ok(estudianteService.registrarEstudiante(request));
    }

    @GetMapping("/ListarEstudiante")
    public ResponseEntity<List<EstudianteResponse>> listar(){
        return ResponseEntity.ok(estudianteService.listar());
    }


    @GetMapping("/obtenerPorId/{id}")
    public ResponseEntity<EstudianteResponse> obtenerPorId(@PathVariable Long id){
        return ResponseEntity.ok(estudianteService.obtenerPorId(id));
    }
    
    @GetMapping("/borrarEstudiante/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Long id){
        estudianteService.borrarEstudiante(id);
        return ResponseEntity.noContent().build();
    }
}
