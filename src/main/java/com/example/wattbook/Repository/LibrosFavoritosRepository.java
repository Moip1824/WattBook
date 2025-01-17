package com.example.wattbook.Repository;

import com.example.wattbook.Entity.LibrosFavoritos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LibrosFavoritosRepository extends JpaRepository<LibrosFavoritos, Long>, JpaSpecificationExecutor<LibrosFavoritos> {

}