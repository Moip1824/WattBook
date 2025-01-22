package com.example.wattbook.Dto;

import com.example.wattbook.Enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Long id;
    private Rol rol;
    private String username;
    private String password;


}
