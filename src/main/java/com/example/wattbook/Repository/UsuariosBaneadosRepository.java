package com.example.wattbook.Repository;

import com.example.wattbook.Entity.Usuario;
import com.example.wattbook.Entity.UsuariosBaneados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosBaneadosRepository extends JpaRepository<UsuariosBaneados, Long> {
    void deleteByUsuarioId(Usuario usuarioId);
}