package com.example.wattbook.Service;

import com.example.wattbook.Dto.ChatMensajesDTO;
import com.example.wattbook.Entity.Chat;
import com.example.wattbook.Entity.ChatMensajes;
import com.example.wattbook.Repository.ChatMensajesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMensajesService {

    @Autowired
    private ChatMensajesRepository chatMensajesRepository;

    public ChatMensajes crearMensaje(ChatMensajesDTO chatMensajesDTO) {
        ChatMensajes chatMensajes = new ChatMensajes();
        chatMensajes.setMensaje(chatMensajesDTO.getMensaje());
        chatMensajes.setFecha(chatMensajesDTO.getFecha());
        chatMensajes.setChatId(chatMensajesDTO.getChatId());
        chatMensajes.setUsuarioId(chatMensajesDTO.getUsuarioId());
        return chatMensajesRepository.save(chatMensajes);
    }

    public void eliminarMensaje(Long id) {
        chatMensajesRepository.deleteById(id);
    }

    public List<ChatMensajes> verMensajesDeChat(Chat chatId) {
        return chatMensajesRepository.findByChatId(chatId);
    }
}