package com.example.wattbook.Service;

import com.example.wattbook.Dto.SeguidorDTO;
import com.example.wattbook.Entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.wattbook.Repository.SeguidoresRepository;
import com.example.wattbook.Entity.Seguidores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeguidoresService implements ISeguidoresService {

    @Autowired
    private SeguidoresRepository seguidoresRepository;

    @Override
    public List<SeguidorDTO> findAll() {
        return seguidoresRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        seguidoresRepository.deleteById(id);
    }

    @Override
    public SeguidorDTO addSeguidor(SeguidorDTO seguidorDTO) {
        Seguidores seguidor = new Seguidores();
        seguidor.setUsuarioId(seguidorDTO.getUserId());
        seguidor.setSeguidorId(seguidorDTO.getSeguidorId());

        return convertToDTO(seguidoresRepository.save(seguidor));
    }

    @Override
    public List<SeguidorDTO> findByUsuarioId(Long usuarioId) {
        List<Seguidores> seguidoresList = seguidoresRepository.findByUsuarioId(usuarioId);
        List<SeguidorDTO> seguidoresDTOList = new ArrayList<>();
        for (Seguidores seguidor : seguidoresList) {
            seguidoresDTOList.add(convertToDTO(seguidor));
        }
        return seguidoresDTOList;
    }

    private SeguidorDTO convertToDTO(Seguidores seguidor) {
        SeguidorDTO dto = new SeguidorDTO();
        dto.setUserId(seguidor.getUsuarioId());
        dto.setSeguidorId(seguidor.getSeguidorId());
        return dto;
    }
}