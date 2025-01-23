package com.example.wattbook.Controller;

import com.example.wattbook.Dto.UsuarioDTO;
import com.example.wattbook.Entity.Libros;
import com.example.wattbook.Entity.Votos;
import com.example.wattbook.Service.LibrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibrosController {

    @Autowired
    private LibrosService libroService;


    @GetMapping
    public ResponseEntity<List<UsuarioDTO.LibroDTO>> obtenerLibros() {
        return ResponseEntity.ok(libroService.obtenerLibrosConVotos());
    }

    @PostMapping("/crear")
    public ResponseEntity<Libros> publicarLibro(@RequestBody Libros libro) {
        return ResponseEntity.ok(libroService.publicarLibro(libro));
    }

    @PostMapping("/votar/{libroId}")
    public ResponseEntity<Votos> votarLibro(@PathVariable Long libroId,
                                            @RequestParam Long usuarioId,
                                            @RequestParam boolean esLike) {
        return ResponseEntity.ok(libroService.votarLibro(libroId, usuarioId, esLike));
    }
}
