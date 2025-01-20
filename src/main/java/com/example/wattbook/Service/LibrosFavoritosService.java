package com.example.wattbook.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.wattbook.Repository.LibrosFavoritosRepository;
import com.example.wattbook.Entity.LibrosFavoritos;

import java.util.List;

@Service
public class LibrosFavoritosService implements ILibrosFavoritosService {

    @Autowired
    private LibrosFavoritosRepository librosFavoritosRepository;

    @Override
    public List<LibrosFavoritos> findAll() {
        return librosFavoritosRepository.findAll();
    }
}