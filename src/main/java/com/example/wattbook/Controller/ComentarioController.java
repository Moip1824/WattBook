package com.example.wattbook.Controller;

import com.example.wattbook.Dto.ComentarioDto;
import com.example.wattbook.Service.ComentariosService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "http://localhost:4200")
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



}
