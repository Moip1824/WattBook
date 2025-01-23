package com.example.wattbook.Repository;

import com.example.wattbook.Entity.Votos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface VotosRepository extends JpaRepository<Votos, Long>, JpaSpecificationExecutor<Votos> {
    Optional<Votos> findByLibroId_IdAndUsuarioId_Id(Long libroId, Long usuarioId);
}
