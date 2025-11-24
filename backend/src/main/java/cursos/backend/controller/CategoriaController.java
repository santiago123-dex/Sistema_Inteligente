package cursos.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cursos.backend.dto.categoria.CategoriaRequest;
import cursos.backend.dto.categoria.CategoriaResponse;
import cursos.backend.service.CategoriaService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api")
public class CategoriaController {
    
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @PostMapping("/register")
    public ResponseEntity<CategoriaResponse> regitrarCategoria(@RequestBody CategoriaRequest request) {
        
        return ResponseEntity.ok(categoriaService.registrarCategoria(request));
    }
    
    @GetMapping("/mostrarCategorias")
    public ResponseEntity<List<CategoriaResponse>> listarCategoria() {
        return ResponseEntity.ok(categoriaService.listarCategoria());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<CategoriaResponse> buscarId(@PathVariable Long id_categoria){
        return ResponseEntity.ok(categoriaService.buscarId(id_categoria));
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<CategoriaResponse> actualizar(@PathVariable Long id_categoria, @RequestBody CategoriaRequest request){
        return ResponseEntity.ok(categoriaService.actualizar(id_categoria, request));
    }

   @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarCategoria(@PathVariable Long id_categoria) {
        categoriaService.borrarCategoria(id_categoria);
        return ResponseEntity.ok("Usuario borrado correctamente");
    }
    
}
