package com.example.wattbook.Controller;

import com.example.wattbook.Dto.UsuarioDTO;
import com.example.wattbook.Entity.Perfil;
import com.example.wattbook.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("/allPerfiles")
    public ResponseEntity<List<UsuarioDTO>> getAllPerfiles() {
        List<UsuarioDTO> perfiles = usuarioService.getAllPerfiles();
        return ResponseEntity.ok(perfiles);
    }
}
