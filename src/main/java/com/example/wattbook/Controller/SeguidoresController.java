package com.example.wattbook.Controller;

import com.example.wattbook.Dto.SeguidorDTO;
import com.example.wattbook.Dto.UsuarioDTO;
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

    @GetMapping("/listaSeguidores/{usuarioId}")
    public ResponseEntity<List<Long>> listaSeguidores(@PathVariable Long usuarioId) {
        List<Long> seguidoresIds = seguidoresService.getSeguidoresIds(usuarioId);
        return ResponseEntity.ok(seguidoresIds);
    }

    @DeleteMapping("/eliminarSeguidor")
    public ResponseEntity<Void> deleteOneSeguidor(@RequestBody Long id) {
        seguidoresService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/anyadirSeguidor")
    public ResponseEntity<SeguidorDTO> addSeguidor(@RequestBody SeguidorDTO seguidorDTO) {
        if (seguidorDTO.getUserId() == null || seguidorDTO.getSeguidorId() == null) {
            return ResponseEntity.badRequest().body(null);
        }
        SeguidorDTO nuevoSeguidor = seguidoresService.addSeguidor(seguidorDTO);
        return ResponseEntity.ok(nuevoSeguidor);
    }

    @GetMapping("/tusSeguidos/{usuarioId}")
    public ResponseEntity<List<SeguidorDTO>> getSeguidoresByUsuarioId(@PathVariable Long usuarioId) {
        List<SeguidorDTO> seguidores = seguidoresService.findByUsuarioId(usuarioId);
        return ResponseEntity.ok(seguidores);
    }
}