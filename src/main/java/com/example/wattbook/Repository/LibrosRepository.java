package com.example.wattbook.Repository;

import com.example.wattbook.Entity.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LibrosRepository extends JpaRepository<Libros, Libros>, JpaSpecificationExecutor<Libros> {
}
