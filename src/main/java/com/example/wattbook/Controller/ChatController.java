package com.example.wattbook.Controller;

import com.example.wattbook.Dto.ChatDTO;
import com.example.wattbook.Entity.Chat;
import com.example.wattbook.Service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/crear")
    public Chat crearChat(@RequestBody ChatDTO chatDTO) {
        return chatService.crearChat(chatDTO);
    }
}