package com.example.wattbook.Service;

import com.example.wattbook.Dto.SeguidorDTO;
import com.example.wattbook.Entity.Seguidores;
import com.example.wattbook.Repository.SeguidoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeguidoresService implements ISeguidoresService {

    @Autowired
    private SeguidoresRepository seguidoresRepository;
    @Autowired
    private UsuarioService usuarioService;

    @Override
    public List<SeguidorDTO> findAll() {
        return seguidoresRepository.findAll().stream().map(this::convertSeguidorToDTO).collect(Collectors.toList());
    }

    @Override
    public SeguidorDTO addSeguidor(SeguidorDTO seguidorDTO) {
        Seguidores seguidor = new Seguidores();
        seguidor.setUsuarioId(seguidorDTO.getUserId());
        seguidor.setSeguidorId(seguidorDTO.getSeguidorId());

        return convertSeguidorToDTO(seguidoresRepository.save(seguidor));
    }

    @Override
    public List<Long> getSeguidoresIds(Long usuarioId) {
        return seguidoresRepository.findByUsuarioId(usuarioId)
                .stream()
                .map(Seguidores::getSeguidorId)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteById(Long seguidorId, Long usuarioId) {
        seguidoresRepository.deleteByUsuarioIdAndSeguidorId(usuarioId, seguidorId);
    }

    @Override
    public List<SeguidorDTO> findByUsuarioId(Long usuarioId) {
        List<Seguidores> seguidoresList = seguidoresRepository.findByUsuarioId(usuarioId);
        List<SeguidorDTO> seguidoresDTOList = new ArrayList<>();
        for (Seguidores seguidor : seguidoresList) {
            seguidoresDTOList.add(convertSeguidorToDTO(seguidor));
        }
        return seguidoresDTOList;
    }

    private SeguidorDTO convertSeguidorToDTO(Seguidores seguidor) {
        return new SeguidorDTO(seguidor.getUsuarioId(), seguidor.getSeguidorId());
    }
}