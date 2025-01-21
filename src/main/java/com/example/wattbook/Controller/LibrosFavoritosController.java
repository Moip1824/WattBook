package com.example.wattbook.Controller;

import com.example.wattbook.Entity.LibrosFavoritos;
import com.example.wattbook.Service.ILibrosFavoritosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros-favoritos")
public class LibrosFavoritosController {

    @Autowired
    private ILibrosFavoritosService librosFavoritosService;

    // Funciona

    @GetMapping("/listaLibros")
    public ResponseEntity<List<LibrosFavoritos>> getLibrosFavoritos() {
        List<LibrosFavoritos> librosFavoritos = librosFavoritosService.findAll();
        return ResponseEntity.ok(librosFavoritos);
    }

    // Funciona

    @DeleteMapping("borrar/{id}")
    public ResponseEntity<Void> deleteOneLibroFavorito(@PathVariable Long id) {
        librosFavoritosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}