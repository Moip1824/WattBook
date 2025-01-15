package com.example.wattbook.Repository;

import com.example.wattbook.Entity.Votos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VotosRepository extends JpaRepository<Votos, Long>, JpaSpecificationExecutor<Votos> {

}