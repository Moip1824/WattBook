package com.example.wattbook.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.wattbook.Entity.LibrosFavoritos;

public interface LibrosFavoritosRepository extends JpaRepository<LibrosFavoritos, Long> {
}