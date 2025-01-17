package com.example.wattbook.Dto;

import com.example.wattbook.Enums.Genero;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistroDTO {

    private  String nombre;
    private String email;

    private String username;
    private String password;

}
