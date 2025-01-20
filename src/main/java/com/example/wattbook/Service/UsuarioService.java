package com.example.wattbook.Service;

import com.example.wattbook.Entity.Perfil;
import com.example.wattbook.Repository.PerfilRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private PerfilRepository perfilRepository;

    public Perfil obtenerPerfil(Long usuarioId) {
        return perfilRepository.findByUsuarioId(usuarioId)
                .orElseThrow(() -> new EntityNotFoundException("Perfil no encontrado para el usuario con ID: " + usuarioId));
    }
}
