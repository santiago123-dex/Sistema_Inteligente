package cursos.backend.dto.estudiantes;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstudianteResponse {
    private Long id;
    private String nombre;
    private String email;
    private List<String> cursos;
}
