package com.example.wattbook.Entity;

import com.example.wattbook.Enums.Genero;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "perfil")
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "descripcion", nullable = true)
    private String descripcion;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "imagen", nullable = true)
    private String imagen;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private Genero generos;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

}
