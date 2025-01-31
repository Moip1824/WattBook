package com.example.wattbook.Service;

import com.example.wattbook.Dto.ChatDTO;
import com.example.wattbook.Entity.Chat;
import com.example.wattbook.Entity.Libros;
import com.example.wattbook.Repository.ChatRepository;
import com.example.wattbook.Repository.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;
    private LibrosRepository librosRepository;

    public Chat crearChat(ChatDTO chatDTO) {

        Libros libro = librosRepository.findById(chatDTO.getLibroId()).orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        Chat chat = new Chat();
        chat.setNombre(chatDTO.getNombre());
        chat.setDescripcion(chatDTO.getDescripcion());
        chat.setImagen(chatDTO.getImagen());
        chat.setLibroId(libro);
        return chatRepository.save(chat);
    }
}