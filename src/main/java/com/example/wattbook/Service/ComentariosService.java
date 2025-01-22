package com.example.wattbook.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.wattbook.Repository.ComentariosRepository;

@Service
public class ComentariosService implements IComentariosService {

    @Autowired
    private ComentariosRepository comentariosRepository;

    @Override
    public void deleteById(Long id) {
        comentariosRepository.deleteById(id);
    }
}