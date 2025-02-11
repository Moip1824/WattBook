package com.example.wattbook.Repository;

import com.example.wattbook.Entity.Comentarios;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.wattbook.Entity.Comentarios;

import java.util.List;

public interface ComentariosRepository extends JpaRepository<Comentarios, Long> {
    List<Comentarios> findByLibroId_Id(Long libroId);
}