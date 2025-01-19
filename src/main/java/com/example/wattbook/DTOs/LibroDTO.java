package com.example.wattbook.DTOs;

import com.example.wattbook.Enums.Genero;

public class LibroDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private String generos;
    private String imagen;
    private Long autorId;
    private Long likes;
    private Long dislikes;

    public LibroDTO(Long id, String nombre, String descripcion, Genero generos, String imagen, Long autorId, Long likes, Long dislikes) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.generos = generos.name();
        this.imagen = imagen;
        this.autorId = autorId;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    // Getters y setters
}
