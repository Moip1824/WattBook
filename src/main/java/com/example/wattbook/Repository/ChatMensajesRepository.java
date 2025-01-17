package com.example.wattbook.Repository;

import com.example.wattbook.Entity.ChatMensajes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ChatMensajesRepository extends JpaRepository<ChatMensajes, Long>, JpaSpecificationExecutor<ChatMensajes> {

}