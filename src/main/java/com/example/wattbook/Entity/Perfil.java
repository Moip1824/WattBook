package com.example.wattbook.Entity;

import com.example.wattbook.Enums.Genero;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@Entity
@Table(name = "perfil")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "email")
    private String email;

    @Column(name = "imagen")
    private String imagen;

    @Enumerated(EnumType.STRING)
    @Column(name = "generos")
    private Genero generos;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonBackReference
    private Usuario usuario;

}
