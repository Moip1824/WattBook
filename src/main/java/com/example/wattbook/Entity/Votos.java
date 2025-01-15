package com.example.wattbook.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "votos")
public class Votos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "libro", nullable = false)
    private Libros libro;

    @Column(nullable = false)
    private Boolean tipoVoto;

    @Column(nullable = false)
    private LocalDateTime fecha;
}