package com.example.wattbook.Service;

import com.example.wattbook.Dto.ChatMensajesDTO;
import com.example.wattbook.Dto.ChatUsuariosDTO;
import com.example.wattbook.Entity.Chat;
import com.example.wattbook.Entity.ChatMensajes;
import com.example.wattbook.Entity.Usuario;
import com.example.wattbook.Repository.ChatMensajesRepository;
import com.example.wattbook.Repository.ChatRepository;
import com.example.wattbook.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMensajesService {

    @Autowired
    private ChatMensajesRepository chatMensajesRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ChatRepository chatRepository;

    public ChatMensajes crearMensaje(ChatMensajesDTO chatMensajesDTO) {

        Usuario usuario = usuarioRepository.findById(chatMensajesDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Chat chat = chatRepository.findById(chatMensajesDTO.getChatId())
                .orElseThrow(() -> new RuntimeException("Chat no encontrado"));

        ChatMensajes chatMensajes = new ChatMensajes();
        chatMensajes.setMensaje(chatMensajesDTO.getMensaje());
        chatMensajes.setFecha(chatMensajesDTO.getFecha());
        chatMensajes.setChatId(chat);
        chatMensajes.setUsuarioId(usuario);
        return chatMensajesRepository.save(chatMensajes);
    }

    public void eliminarMensaje(Long id) {
        chatMensajesRepository.deleteById(id);
    }

    public List<ChatMensajes> verMensajesDeChat(Chat chatId) {
        return chatMensajesRepository.findByChatId(chatId);
    }
}