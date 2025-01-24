package com.example.wattbook.Service;

import com.example.wattbook.Dto.ComentarioDto;
import com.example.wattbook.Entity.Comentarios;
import com.example.wattbook.Entity.Libros;
import com.example.wattbook.Entity.Usuario;
import com.example.wattbook.Repository.ComentariosRepository;
import com.example.wattbook.Repository.LibrosRepository;
import com.example.wattbook.Repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.wattbook.Repository.ComentariosRepository;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ComentariosService implements IComentariosService {

    @Autowired
    private ComentariosRepository comentariosRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private LibrosRepository librosRepository;

    public List<ComentarioDto> getAllComentarios() {
        return comentariosRepository.findAll().stream().map(this::convDto).collect(Collectors.toList());
    }
    @Override
    public void deleteById(Long id) {
        comentariosRepository.deleteById(id);
    }

    public void agregarComentario(ComentarioDto comentarioDto) {
        Usuario usuario = usuarioRepository.findById(comentarioDto.getUsuarioId()).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Libros libro = librosRepository.findById(comentarioDto.getLibroId()).orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        Comentarios comentario = new Comentarios();
        comentario.setUsuarioId(usuario);
        comentario.setLibroId(libro);
        comentario.setComentario(comentarioDto.getComentario());
        comentario.setFecha((Date) comentarioDto.getFecha());

        comentariosRepository.save(comentario);

    }


    private ComentarioDto convDto (Comentarios comentario) {
        ComentarioDto comentarioDto = new ComentarioDto();
        comentarioDto.setUsuarioId(comentario.getUsuarioId().getId());
        comentarioDto.setLibroId(comentario.getLibroId().getId());
        comentarioDto.setComentario(comentario.getComentario());
        comentarioDto.setFecha(comentario.getFecha());
        return comentarioDto;
    }

}