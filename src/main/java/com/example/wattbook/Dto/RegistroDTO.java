package com.example.wattbook.Dto;

import com.example.wattbook.Enums.Genero;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RegistroDTO {

    private Long id;
    private String nombre;
    private String apellidos;
    private String descripcion;
    private String imagen;
    private Genero generos;
    private String email;


    private String username;
    private String password;

}
