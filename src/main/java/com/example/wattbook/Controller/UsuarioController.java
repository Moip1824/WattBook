package com.example.wattbook.Controller;

import com.example.wattbook.Entity.Perfil;
import com.example.wattbook.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}/perfil")
    public ResponseEntity<Perfil> obtenerPerfilUsuario(@PathVariable Long id) {
        Perfil perfil = usuarioService.obtenerPerfil(id);
        System.out.println(perfil);
        return ResponseEntity.ok(perfil);
    }

}
