package pe.edu.cibertec.CL2_security.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.CL2_security.model.Usuario;
import pe.edu.cibertec.CL2_security.repository.UsuarioRepository;
import pe.edu.cibertec.CL2_security.service.IUsuarioService;


@RequiredArgsConstructor
@Service
public class UsuarioService implements IUsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario obtenerUsuarioXcodigo(String codigo) {
        return usuarioRepository.findByCodigo(codigo);
    }

}
