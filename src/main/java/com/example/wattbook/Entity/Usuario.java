package com.example.wattbook.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String nomUsu;

    @Column(nullable = false, length = 255)
    private String contrasena;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Rol rol;

    public enum Rol {
        ADMIN, USUARIO
    }

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Perfil perfil;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Libros> libros;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Comentarios> comentarios;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Chat> chats;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Votos> votos;

    @OneToMany(mappedBy = "usuario1", cascade = CascadeType.ALL)
    private List<Seguidores> seguidores1;

    @OneToMany(mappedBy = "usuario2", cascade = CascadeType.ALL)
    private List<Seguidores> seguidores2;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<UsuariosBaneados> usuariosBaneados;
}