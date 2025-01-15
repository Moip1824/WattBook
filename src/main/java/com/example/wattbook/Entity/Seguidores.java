package com.example.wattbook.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "seguidores")
public class Seguidores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario1", nullable = false)
    private Usuario usuario1;

    @ManyToOne
    @JoinColumn(name = "usuario2", nullable = false)
    private Usuario usuario2;
}