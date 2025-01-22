package com.example.wattbook.Service;

import com.example.wattbook.Dto.LibroDto;
import com.example.wattbook.Entity.Libros;
import com.example.wattbook.Repository.LibrosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LibroService {
    @Autowired
    private LibrosRepository librosRepository;
    public List<LibroDto> getAllLibros() {
        return librosRepository.findAll().stream().map(this::convDto).collect(Collectors.toList());
    }
    public LibroDto getLibro(Long id) {
        return librosRepository.findById(id).map(this::convDto).orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

    private LibroDto convDto(Libros libro) {
        LibroDto libroDto = new LibroDto();
        libroDto.setId(libro.getId());
        libroDto.setNombre(libro.getNombre());
        libroDto.setDescripcion(libro.getDescripcion());
        libroDto.setGeneros(libro.getGeneros());
        libroDto.setFechaPublicacion(libro.getFechaPublicacion());
        libroDto.setImagen(libro.getImagen());
        libroDto.setAutorId(libro.getAutorId().getId());
        return libroDto;
    }

}
