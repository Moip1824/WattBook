package com.example.wattbook.Service;

import com.example.wattbook.Dto.ChatUsuariosDTO;
import com.example.wattbook.Entity.ChatUsuarios;
import com.example.wattbook.Entity.Usuario;
import com.example.wattbook.Repository.ChatUsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatUsuariosService {

    @Autowired
    private ChatUsuariosRepository chatUsuariosRepository;

    public ChatUsuarios crearUsuario(ChatUsuariosDTO chatUsuariosDTO) {
        ChatUsuarios chatUsuarios = new ChatUsuarios();
        chatUsuarios.setUsuarioId(chatUsuariosDTO.getUsuarioId());
        chatUsuarios.setChatId(chatUsuariosDTO.getChatId());
        return chatUsuariosRepository.save(chatUsuarios);
    }

    public void eliminarUsuario(Long id) {
        chatUsuariosRepository.deleteById(id);
    }

    public List<ChatUsuarios> verUsuarios() {
        return chatUsuariosRepository.findAll();
    }

    public List<ChatUsuarios> verChatsDeUsuario(Usuario usuarioId) {
        return chatUsuariosRepository.findByUsuarioId(usuarioId);
    }
}