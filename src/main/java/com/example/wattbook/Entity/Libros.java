package com.example.wattbook.Entity;

import com.example.wattbook.Enums.Genero;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "libros")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Libros implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genero generos;

    @Column(name = "fecha_publicacion")
    private Date fechaPublicacion;

    @Column(columnDefinition = "TEXT", name = "imagen")
    private String imagen;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "autor_id", nullable = false)
    private Usuario autorId;

}
