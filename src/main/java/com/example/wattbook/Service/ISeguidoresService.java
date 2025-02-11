package com.example.wattbook.Service;

import com.example.wattbook.Dto.SeguidorDTO;
import java.util.List;

public interface ISeguidoresService {
    List<SeguidorDTO> findAll();
    void deleteById(Long id);
    SeguidorDTO addSeguidor(SeguidorDTO seguidorDTO);
    List<SeguidorDTO> findByUsuarioId(Long usuarioId);
}