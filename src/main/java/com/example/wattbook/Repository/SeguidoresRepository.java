package com.example.wattbook.Repository;

import com.example.wattbook.Entity.Seguidores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SeguidoresRepository extends JpaRepository<Seguidores, Long>, JpaSpecificationExecutor<Seguidores> {

}