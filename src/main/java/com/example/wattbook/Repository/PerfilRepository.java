package com.example.wattbook.Repository;

import com.example.wattbook.Entity.Perfil;
import com.example.wattbook.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface PerfilRepository extends JpaRepository<Perfil, Long>, JpaSpecificationExecutor<Perfil> {
    Optional<Perfil> findByUsuarioId(Long usuarioId);
    Perfil findByUsuario_Id(Long usuarioId); // Buscar por ID del usuario
}
