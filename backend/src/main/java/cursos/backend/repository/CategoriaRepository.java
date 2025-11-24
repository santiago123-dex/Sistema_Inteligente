package cursos.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cursos.backend.entity.Categoria;
import java.util.Optional;



public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    Optional<Categoria> findByNombreCategoria(String nombre_categoria);
    Optional<Categoria> findById(Long id);
}
