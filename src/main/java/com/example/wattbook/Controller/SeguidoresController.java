package com.example.wattbook.Controller;

import com.example.wattbook.Dto.RespuestaDTO;
import com.example.wattbook.Dto.SeguidorDTO;
import com.example.wattbook.Entity.Seguidores;
import com.example.wattbook.Service.ISeguidoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/seguidores")
public class SeguidoresController {

    @Autowired
    private ISeguidoresService seguidoresService;

    // Funciona

    @GetMapping("/listaSeguidores")
    public ResponseEntity<List<Seguidores>> getSeguidores() {
        List<Seguidores> seguidores = seguidoresService.findAll();
        return ResponseEntity.ok(seguidores);
    }

    // Funciona

    @DeleteMapping("/eliminarSeguidor")
    public ResponseEntity<Void> deleteSeguidor(@RequestBody SeguidorDTO seguidorDTO) {
        seguidoresService.deleteById(seguidorDTO.getId());
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/anyadirSeguidor")
    public Seguidores addSeguidor(@RequestBody RespuestaDTO.SeguidoresDTO seguidoresDTO) {
        Seguidores seguidores = new Seguidores();
        seguidores.setUsuarioId(seguidoresDTO.getUsuarioId());
        seguidores.setSeguidorId(seguidoresDTO.getSeguidorId());

        return seguidoresService.addSeguidor(seguidores);
    }
}
