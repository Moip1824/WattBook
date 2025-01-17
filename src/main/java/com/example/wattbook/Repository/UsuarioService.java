package com.example.wattbook.Repository;

import com.example.wattbook.Dto.RegistroDTO;
import com.example.wattbook.Entity.Perfil;
import com.example.wattbook.Entity.Usuario;
import com.example.wattbook.security.JWTService;
import com.example.wattbook.Enums.Rol;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

public class UsuarioService implements UserDetailsService {

    private UsuarioRepository usuarioRepository;
    private PerfilService perfilService;
    private final PasswordEncoder passwordEncoder;
    private JWTService jwtService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findTopByUsername(username).orElse(null);
    }

    public Usuario registrarUsuario(RegistroDTO dto){

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombreusuario(dto.getUsername());
        nuevoUsuario.setContrasena(passwordEncoder.encode(dto.getPassword()));
        nuevoUsuario.setRol(Rol.USUARIO);


        Perfil perfil = new Perfil();
        perfil.setNombre(dto.getNombre());
        perfil.setEmail(dto.getEmail());

        Usuario usuarioGuardado = usuarioRepository.save(nuevoUsuario);


        perfil.setUsuario(usuarioGuardado);
        Perfil perfilGuardado = perfilService.guardarPerfil(perfil);


        return usuarioGuardado;
    }



}
