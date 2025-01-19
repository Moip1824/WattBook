package com.example.wattbook.Service;

import com.example.wattbook.DTOs.LibroDTO;
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

@Service
public class LibrosService {
    @Autowired
    private LibrosRepository librosRepository;

    @Autowired
    private VotosRepository votoRepository;

    @Autowired
    private UsuarioRepository UsuarioRepository;

    public List<LibroDTO> obtenerLibrosConVotos() {
        return librosRepository.obtenerLibrosYVotos();
    }

    public Libros publicarLibro(Libros libro) {
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

}
