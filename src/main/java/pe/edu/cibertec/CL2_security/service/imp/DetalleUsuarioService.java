package pe.edu.cibertec.CL2_security.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.CL2_security.model.Usuario;
import pe.edu.cibertec.CL2_security.service.IUsuarioService;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class DetalleUsuarioService implements UserDetailsService {

    private final IUsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.obtenerUsuarioXcodigo(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return crearUserDetail(usuario);
    }



    private UserDetails crearUserDetail(Usuario usuario) {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("ROLE_" + usuario.getRol()));

        return new User(
                usuario.getCodigo(),
                usuario.getPassword(),
                usuario.getActivo(),
                true,
                true,
                true,
                authorityList);
    }

}
