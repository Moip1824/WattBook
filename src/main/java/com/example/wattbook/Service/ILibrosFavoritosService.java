package com.example.wattbook.Service;

import com.example.wattbook.DTOs.LibrosFavoritosDTO;
import com.example.wattbook.Entity.LibrosFavoritos;
import java.util.List;

public interface ILibrosFavoritosService {
    List<LibrosFavoritos> findAll();
    void deleteById(Long id);
    LibrosFavoritos addLibroFavorito(LibrosFavoritosDTO libroFavoritoDTO);
}