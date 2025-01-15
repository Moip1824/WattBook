package com.example.wattbook.Repository;

import com.example.wattbook.Entity.Comentarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ComentariosRepository extends JpaRepository<Comentarios, Long>, JpaSpecificationExecutor<Comentarios> {

}