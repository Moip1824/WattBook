package com.example.wattbook.Repository;

import com.example.wattbook.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.wattbook.Entity.Seguidores;
import java.util.List;

public interface SeguidoresRepository extends JpaRepository<Seguidores, Long> {
    List<Seguidores> findByUsuarioId(Long usuarioId);
}