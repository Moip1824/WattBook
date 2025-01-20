package com.example.wattbook.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.wattbook.Entity.Comentarios;

public interface ComentariosRepository extends JpaRepository<Comentarios, Long> {
}