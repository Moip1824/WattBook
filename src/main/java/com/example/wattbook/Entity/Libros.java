package com.example.wattbook.Entity;

import com.example.wattbook.Enums.Genero;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "libros")
public class Libros implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genero generos;

    @Column(name = "fecha_publicacion", nullable = false)
    private Date fechaPublicacion;

    @Column(name = "imagen", nullable = false)
    private String imagen;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Usuario autorId;

}
