package com.example.wattbook.Controller;

import com.example.wattbook.Dto.ChatUsuariosDTO;
import com.example.wattbook.Entity.ChatUsuarios;
import com.example.wattbook.Entity.Usuario;
import com.example.wattbook.Service.ChatUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chatusuario")
public class ChatUsuariosController {

    @Autowired
    private ChatUsuariosService chatUsuariosService;

    @PostMapping("/crear")
    public ChatUsuarios crearUsuario(@RequestBody ChatUsuariosDTO chatUsuariosDTO) {
        return chatUsuariosService.crearUsuario(chatUsuariosDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        chatUsuariosService.eliminarUsuario(id);
    }

    @GetMapping("/ver")
    public List<ChatUsuarios> verUsuarios() {
        return chatUsuariosService.verUsuarios();
    }

    @GetMapping("/verchats/{usuarioId}")
    public List<ChatUsuarios> verChatsDeUsuario(@PathVariable Usuario usuarioId) {
        return chatUsuariosService.verChatsDeUsuario(usuarioId);
    }
}