package com.example.wattbook.Service;

import com.example.wattbook.Entity.Seguidores;
import java.util.List;

public interface ISeguidoresService {
    List<Seguidores> findAll();
    Seguidores addSeguidor(Seguidores seguidor);
    void deleteById(Long id);
}