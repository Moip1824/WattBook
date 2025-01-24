package com.example.wattbook.Repository;

import com.example.wattbook.Dto.UsuarioDTO;
import com.example.wattbook.Entity.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibrosRepository extends JpaRepository<Libros, Long>, JpaSpecificationExecutor<Libros> {

    @Query("SELECT new com.example.wattbook.Dto.LibroDTO(" +
            "l.id, l.nombre, l.descripcion, l.generos, l.imagen, l.autorId.id, " +
            "SUM(CASE WHEN v.tipoVoto = true THEN 1 ELSE 0 END), " +
            "SUM(CASE WHEN v.tipoVoto = false THEN 1 ELSE 0 END)) " +
            "FROM Libros l LEFT JOIN Votos v ON l.id = v.libroId.id " +
            "LEFT JOIN l.autorId a " +
            "GROUP BY l.id, l.nombre, l.descripcion, l.generos, l.imagen, l.autorId.id")
    List<UsuarioDTO.LibroDTO> obtenerLibrosYVotos();
}
