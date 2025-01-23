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


    public LibroDTO() {
    }


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGeneros() {
        return generos;
    }

    public void setGeneros(String generos) {
        this.generos = generos;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Long getDislikes() {
        return dislikes;
    }

    public void setDislikes(Long dislikes) {
        this.dislikes = dislikes;
    }
}
