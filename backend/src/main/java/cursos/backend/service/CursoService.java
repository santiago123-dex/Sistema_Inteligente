package cursos.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cursos.backend.entity.Categoria;
import cursos.backend.entity.Cursos;
import cursos.backend.repository.CategoriaRepository;
import cursos.backend.repository.CursoRepository;

@Service
public class CursoService {

    private CursoRepository cursoRepository;

    private CategoriaRepository categoriaRepository;

    public Cursos crearCurso(Cursos curso, Long categoriaId) {
        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        curso.setCategoria(categoria);
        return cursoRepository.save(curso);
    }

    public List<Cursos> listarCursos() {
        return cursoRepository.findAll();
    }

    public Cursos obtenerCursoPorId(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
    }

    public Cursos actualizarCurso(Long id, Cursos cursoActualizado) {
        Cursos curso = obtenerCursoPorId(id);
        curso.setTituloCurso(cursoActualizado.getTituloCurso());
        curso.setDescripcion(cursoActualizado.getDescripcion());
        // opcional: actualizar categoría
        if(cursoActualizado.getCategoria() != null){
            curso.setCategoria(cursoActualizado.getCategoria());
        }
        return cursoRepository.save(curso);
    }

    public void eliminarCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}

