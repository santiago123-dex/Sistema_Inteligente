package cursos.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cursos.backend.entity.Cursos;

@Repository
public interface CursoRepository extends JpaRepository<Cursos, Long> {
    
}
