package com.example.wattbook.Entity;

import com.example.wattbook.Enums.Genero;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
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

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "imagen")
    private String imagen;

    @Enumerated(EnumType.STRING)
    @Column(name = "generos")
    private Genero generos;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonBackReference
    private Usuario usuario;



    @Override
    public String toString() {
        return "Perfil{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", email='" + email + '\'' +
                ", imagen='" + imagen + '\'' +
                ", generos=" + generos +
                '}';
    }


}
