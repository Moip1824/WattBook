package com.example.wattbook.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.wattbook.Repository.SeguidoresRepository;
import com.example.wattbook.Entity.Seguidores;

import java.util.List;

@Service
public class SeguidoresService implements ISeguidoresService {

    @Autowired
    private SeguidoresRepository seguidoresRepository;

    @Override
    public List<Seguidores> findAll() {
        return seguidoresRepository.findAll();
    }

    @Override
    public Seguidores addSeguidor(Seguidores seguidor) {
        return seguidoresRepository.save(seguidor);
    }


    @Override
    public void deleteById(Long id) {
        seguidoresRepository.deleteById(id);
    }
}