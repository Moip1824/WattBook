package com.example.wattbook.Service;

import com.example.wattbook.Dto.LibroLeerDto;
import com.example.wattbook.Dto.UsuarioDTO;
import com.example.wattbook.Entity.Libros;
import com.example.wattbook.Entity.Usuario;
import com.example.wattbook.Entity.Votos;
import com.example.wattbook.Repository.LibrosRepository;
import com.example.wattbook.Repository.UsuarioRepository;
import com.example.wattbook.Repository.VotosRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibrosService {
    @Autowired
    private LibrosRepository librosRepository;

    @Autowired
    private VotosRepository votoRepository;

    @Autowired
    private UsuarioRepository UsuarioRepository;

    public List<UsuarioDTO.LibroDTO> obtenerLibrosConVotos() {
        return librosRepository.obtenerLibrosYVotos();
    }

    public Libros publicarLibro(Libros libro) {
        // Obtener el autor desde la base de datos utilizando su ID
        Usuario autor = UsuarioRepository.findById(libro.getAutorId().getId()).orElseThrow(() -> new RuntimeException("Autor no encontrado"));

        // Asocia el autor con el libro
        libro.setAutorId(autor);

        // Luego guarda el libro
        return librosRepository.save(libro);
    }


    public Votos votarLibro(Long libroId, Long usuarioId, boolean esLike) {

        Optional<Libros> libroOptional = librosRepository.findById(libroId);
        Optional<Usuario> usuarioOptional = UsuarioRepository.findById(usuarioId);

        if (libroOptional.isEmpty() || usuarioOptional.isEmpty()) {
            throw new EntityNotFoundException("Libro o Usuario no encontrados");
        }

        return votoRepository.findByLibroId_IdAndUsuarioId_Id(libroId, usuarioId)
                .map(votoExistente -> {
                    votoExistente.setTipoVoto(esLike);
                    return votoRepository.save(votoExistente);
                })
                .orElseGet(() -> {
                    Votos nuevoVoto = new Votos();
                    nuevoVoto.setLibroId(libroOptional.get());
                    nuevoVoto.setUsuarioId(usuarioOptional.get());
                    nuevoVoto.setTipoVoto(esLike);
                    return votoRepository.save(nuevoVoto);
                });
    }
    public List<LibroLeerDto> getAllLibros() {
        return librosRepository.findAll().stream().map(this::convDto).collect(Collectors.toList());
    }
    public LibroLeerDto getLibro(Long id) {
        return librosRepository.findById(id).map(this::convDto).orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

    private LibroLeerDto convDto(Libros libro) {
        LibroLeerDto libroDto = new LibroLeerDto();
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
