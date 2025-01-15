package com.example.wattbook.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "libros")
public class Libros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Column
    private String descripcion;

    @Column(nullable = false, length = 50)
    private String generos;

    @Column(nullable = false)
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "autor", nullable = false)
    private Usuario autor;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(length = 255)
    private String imagen;
}