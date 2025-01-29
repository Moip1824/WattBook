package com.example.wattbook.Controller;

import com.example.wattbook.Dto.ComentarioDto;
import com.example.wattbook.Service.ComentariosService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/comentarios")
@RequiredArgsConstructor
public class ComentarioController {
    private final ComentariosService comentariosService;

    @PostMapping
    public ResponseEntity<String> agregarComentario(@RequestBody ComentarioDto comentarioDto) {
        comentariosService.agregarComentario(comentarioDto);
        return ResponseEntity.ok("Comentario agregado");
    }

    @GetMapping("/libro/{libroId}")
    public ResponseEntity<List<ComentarioDto>> obtenerComentariosPorLibro(@PathVariable Long libroId) {
        List<ComentarioDto> comentarios = comentariosService.obtenerComentariosPorLibro(libroId);
        return ResponseEntity.ok(comentarios);
    }



}
