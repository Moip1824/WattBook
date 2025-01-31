package com.example.wattbook.Service;

import com.example.wattbook.Dto.ChatDTO;
import com.example.wattbook.Entity.Chat;
import com.example.wattbook.Repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    public Chat crearChat(ChatDTO chatDTO) {
        Chat chat = new Chat();
        chat.setNombre(chatDTO.getNombre());
        chat.setDescripcion(chatDTO.getDescripcion());
        chat.setImagen(chatDTO.getImagen());
        return chatRepository.save(chat);
    }
}