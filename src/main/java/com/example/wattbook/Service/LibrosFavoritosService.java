package com.example.wattbook.Service;

import com.example.wattbook.Dto.LibrosFavoritosDTO;
import com.example.wattbook.Entity.Libros;
import com.example.wattbook.Entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.wattbook.Repository.LibrosFavoritosRepository;
import com.example.wattbook.Entity.LibrosFavoritos;

import java.util.List;

@Service
public class LibrosFavoritosService implements ILibrosFavoritosService {

    @Autowired
    private LibrosFavoritosRepository librosFavoritosRepository;

    @Override
    public List<LibrosFavoritos> findAll() {
        return librosFavoritosRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        librosFavoritosRepository.deleteById(id);
    }

    @Override
    public LibrosFavoritos addLibroFavorito(LibrosFavoritosDTO libroFavoritoDTO) {
        LibrosFavoritos libroFavorito = new LibrosFavoritos();
        Usuario usuario = new Usuario();
        usuario.setId(libroFavoritoDTO.getUserId());
        libroFavorito.setUsuarioId(usuario);

        Libros libro = new Libros();
        libro.setId(libroFavoritoDTO.getLibroId());
        libroFavorito.setLibroId(libro);

        return librosFavoritosRepository.save(libroFavorito);
    }
}