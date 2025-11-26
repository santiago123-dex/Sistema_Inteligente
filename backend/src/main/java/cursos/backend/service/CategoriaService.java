package cursos.backend.service;

import java.util.List;


import org.springframework.stereotype.Service;

import cursos.backend.dto.categoria.CategoriaRequest;
import cursos.backend.dto.categoria.CategoriaResponse;
import cursos.backend.entity.Categoria;
import cursos.backend.repository.CategoriaRepository;
import jakarta.transaction.Transactional;

@Service
public class CategoriaService {
    
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    @Transactional
    public CategoriaResponse registrarCategoria(CategoriaRequest request){
        
        if(request.getNombreCategoria() == null || request.getNombreCategoria().trim().isEmpty()){
            throw new RuntimeException("El nombre de la categoría no puede estar vacío");
        }

        if(categoriaRepository.findByNombreCategoria(request.getNombreCategoria()).isPresent()){
            throw new RuntimeException("La categoria ya existe");
        }

        Categoria categoria = Categoria.builder()
            .nombreCategoria(request.getNombreCategoria())
            .build();

        Categoria categoriaSaved = categoriaRepository.save(categoria);
        return CategoriaResponse.builder()
            .nombreCategoria(categoriaSaved.getNombreCategoria())
            .message("Categoria registrada correctamente")
            .build();
    }

    //Listar las categorias
    public List<CategoriaResponse> listarCategoria(){
        return categoriaRepository.findAll().stream()
            .map(categoria -> CategoriaResponse.builder()
            .nombreCategoria(categoria.getNombreCategoria())
            .build())
        .toList();
    }

    //Buscar por Id
    @Transactional
    public CategoriaResponse buscarId(Long id_categoria){
        Categoria categoria = categoriaRepository.findById(id_categoria).orElseThrow(() -> new RuntimeException("Categoria no encontrada"));

        CategoriaResponse response = CategoriaResponse.builder()
            .nombreCategoria(categoria.getNombreCategoria())
            .build();

            return response;
        
    }

    // Actulizar 
    @Transactional
    public CategoriaResponse actualizar(Long id_categoria, CategoriaRequest request){

        Categoria categoria = categoriaRepository.findById(id_categoria).orElseThrow(() -> new RuntimeException("Categoria no encontrada"));

        categoria.setNombreCategoria(request.getNombreCategoria());

        categoriaRepository.save(categoria);

        return CategoriaResponse.builder()
            .nombreCategoria(categoria.getNombreCategoria())
            .message("Categoria actualizada correctamente")
            .build();
    }

    @Transactional
    public void borrarCategoria(Long id_categoria){
        categoriaRepository.deleteById(id_categoria);
    }

}
