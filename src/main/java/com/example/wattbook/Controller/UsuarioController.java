package com.example.wattbook.Controller;

import com.example.wattbook.Entity.Perfil;
import com.example.wattbook.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/perfil/{usuarioid}")
    public ResponseEntity<Optional<Perfil>> obtenerPerfil(Long idUsuario){
        return ResponseEntity.ok(usuarioService.getUsuarioById(idUsuario));
    }
}
