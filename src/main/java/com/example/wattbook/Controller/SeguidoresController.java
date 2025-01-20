package com.example.wattbook.Controller;

import com.example.wattbook.Entity.Seguidores;
import com.example.wattbook.Service.ISeguidoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seguidores")
public class SeguidoresController {

    @Autowired
    private ISeguidoresService seguidoresService;

    @GetMapping
    public ResponseEntity<List<Seguidores>> getSeguidores() {
        List<Seguidores> seguidores = seguidoresService.findAll();
        return ResponseEntity.ok(seguidores);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteSeguidor() {
        seguidoresService.deleteById();
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Seguidores> addSeguidor(@RequestBody Seguidores seguidor) {
        Seguidores seguidorGuardado = seguidoresService.addSeguidor(seguidor);
        return ResponseEntity.ok(seguidorGuardado);
    }
}