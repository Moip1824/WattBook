package com.example.wattbook.Entity;

import com.example.wattbook.Enums.Genero;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "perfil")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Perfil {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "imagen", nullable = false)
    private String imagen;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genero generos;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

}
