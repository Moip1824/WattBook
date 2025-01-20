package com.example.wattbook.Controller;

import com.example.wattbook.Entity.LibrosFavoritos;
import com.example.wattbook.Service.ILibrosFavoritosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/libros-favoritos")
public class LibrosFavoritosController {

    @Autowired
    private ILibrosFavoritosService librosFavoritosService;

    @GetMapping
    public ResponseEntity<List<LibrosFavoritos>> getLibrosFavoritos() {
        List<LibrosFavoritos> librosFavoritos = librosFavoritosService.findAll();
        return ResponseEntity.ok(librosFavoritos);
    }
}