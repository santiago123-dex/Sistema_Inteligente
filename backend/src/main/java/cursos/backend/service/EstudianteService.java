package cursos.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cursos.backend.dto.estudiantes.EstudianteRequest;
import cursos.backend.dto.estudiantes.EstudianteResponse;
import cursos.backend.entity.Cursos;
import cursos.backend.entity.Estudiante;
import cursos.backend.repository.CursoRepository;
import cursos.backend.repository.EstudianteRepository;
import jakarta.transaction.Transactional;

@Service
public class EstudianteService {

    public final EstudianteRepository estudianteRepository;
    private final CursoRepository cursoRepository;

    public EstudianteService(EstudianteRepository estudianteRepository, CursoRepository cursoRepository) {
        this.estudianteRepository = estudianteRepository;
        this.cursoRepository = cursoRepository;
    }

    @Transactional
    public EstudianteResponse registrarEstudiante(EstudianteRequest request) {
        List<Cursos> cursos = cursoRepository.findAllById(request.getCursosIds());

        if (cursos.isEmpty()) {
            throw new RuntimeException("No existen cursos con ese ID");
        }

        Estudiante estudiante = Estudiante.builder()
                .nombre(request.getNombre())
                .email(request.getEmail())
                .cursos(cursos)
                .build();

        estudianteRepository.save(estudiante);

        return new EstudianteResponse(
                estudiante.getId_estudiante(),
                estudiante.getNombre(),
                estudiante.getEmail(),
                cursos.stream()
                        .map(Cursos -> Cursos.getTituloCurso())
                        .toList());

    }

     public List<EstudianteResponse> listar(){
        return estudianteRepository.findAll().stream()
            .map(e -> new EstudianteResponse(
                e.getId_estudiante(),
                e.getNombre(),
                e.getEmail(),
                e.getCursos().stream().map(c -> c.getTituloCurso()).toList()
            ))
            .toList();
    }

    @Transactional
    public void borrarEstudiante(Long id_estudiante){
        estudianteRepository.deleteById(id_estudiante);
    }

    @Transactional
    public EstudianteResponse obtenerPorId(Long id_estudiante) {
        Estudiante estudiante = estudianteRepository.findById(id_estudiante)
            .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        
        List<Cursos> cursos = estudiante.getCursos();
        
        return new EstudianteResponse(
            estudiante.getId_estudiante(),
            estudiante.getNombre(),
            estudiante.getEmail(),
            cursos.stream().map(Cursos::getTituloCurso).toList()
        );
    }

}
