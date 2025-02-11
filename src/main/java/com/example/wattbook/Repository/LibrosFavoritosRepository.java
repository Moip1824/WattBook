package com.example.wattbook.Repository;

import com.example.wattbook.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.wattbook.Entity.LibrosFavoritos;
import java.util.List;

public interface LibrosFavoritosRepository extends JpaRepository<LibrosFavoritos, Long> {
    List<LibrosFavoritos> findByUsuarioId(Usuario usuarioId);
}