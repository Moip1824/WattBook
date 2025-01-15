package com.example.wattbook.Repository;

import com.example.wattbook.Entity.UsuariosBaneados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UsuariosBaneadosRepository extends JpaRepository<UsuariosBaneados, Long>, JpaSpecificationExecutor<UsuariosBaneados> {

}