package com.example.wattbook.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column
    private String descripcion;

    @Column(nullable = false, length = 100, unique = true)
    private String correo;

    @Column(length = 255)
    private String imagen;

    @Column(nullable = false, length = 50)
    private String generos;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}