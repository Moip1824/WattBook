package com.example.wattbook.Controller;

import com.example.wattbook.Entity.Libros;
import com.example.wattbook.Service.VotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/votos")
public class VotosController {
    @Autowired
    private VotosService votoService;

    @GetMapping("/top4")
    public ResponseEntity<List<Libros>> getTop4LibrosConMasLikes() {
        return ResponseEntity.ok(votoService.obtenerTop4LibrosConMasLikes());
    }
}
