package pe.edu.cibertec.CL2_security.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UsuarioResponseDto {
    private Integer idusuario;
    private String nomusuario;
    private String token;
}
