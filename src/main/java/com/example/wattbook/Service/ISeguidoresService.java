package com.example.wattbook.Service;

import com.example.wattbook.Dto.SeguidorDTO;

import java.util.List;

public interface ISeguidoresService {
    List<SeguidorDTO> findAll();
    SeguidorDTO addSeguidor(SeguidorDTO seguidorDTO);
    List<Long> getSeguidoresIds(Long usuarioId);
    void deleteById(Long seguidorId, Long usuarioId);
    List<SeguidorDTO> findByUsuarioId(Long usuarioId);
}