package com.example.wattbook.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios_baneados")
public class UsuariosBaneados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private String motivo;
}