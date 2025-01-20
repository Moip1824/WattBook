package com.example.wattbook.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.wattbook.Entity.Seguidores;

public interface SeguidoresRepository extends JpaRepository<Seguidores, Long> {
}