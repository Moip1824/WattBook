package com.example.wattbook.Repository;

import com.example.wattbook.Entity.Chat;
import com.example.wattbook.Entity.ChatMensajes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ChatMensajesRepository extends JpaRepository<ChatMensajes, Long>, JpaSpecificationExecutor<ChatMensajes> {

    List<ChatMensajes> findByChatId(Chat chatId);
}