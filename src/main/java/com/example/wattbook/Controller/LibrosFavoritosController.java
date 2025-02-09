package com.example.wattbook.Controller;

import com.example.wattbook.Dto.LibroDTO;
import com.example.wattbook.Dto.LibrosFavoritosDTO;
import com.example.wattbook.Entity.LibrosFavoritos;
import com.example.wattbook.Service.ILibrosFavoritosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
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

    @DeleteMapping("/eliminarLibroFav")
    public ResponseEntity<Void> deleteOneLibroFavorito(@RequestBody LibroDTO libroDTO) {
        librosFavoritosService.deleteById(libroDTO.getId());
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/anyadirLibroFavorito")
    public ResponseEntity<LibrosFavoritos> addLibroFavorito(@RequestBody LibrosFavoritosDTO libroFavoritoDTO) {
        if (libroFavoritoDTO.getUserId() == null || libroFavoritoDTO.getLibroId() == null) {
            return ResponseEntity.badRequest().body(null);
        }
        LibrosFavoritos nuevoLibroFavorito = librosFavoritosService.addLibroFavorito(libroFavoritoDTO);
        return ResponseEntity.ok(nuevoLibroFavorito);
    }
}