package com.example.wattbook.Service;

import com.example.wattbook.Entity.Perfil;
import com.example.wattbook.Entity.Usuario;
import com.example.wattbook.Repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.wattbook.Repository.UsuarioRepository;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilRepository perfilRepository;


    public Optional<Perfil> getUsuarioById(Long id) {
        return perfilRepository.findByUsuarioId(id);
    }
}
