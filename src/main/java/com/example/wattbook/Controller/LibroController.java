package com.example.wattbook.Controller;

import com.example.wattbook.Dto.LibroDto;
import com.example.wattbook.Service.LibroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/libros")
@Controller
@RequiredArgsConstructor
public class LibroController {
    private final LibroService libroService;



    @GetMapping
    public ResponseEntity<List<LibroDto>> getAllLibros() {
        return ResponseEntity.ok(libroService.getAllLibros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroDto> getLibro(@PathVariable Long id) {
        return ResponseEntity.ok(libroService.getLibro(id));
    }


}
