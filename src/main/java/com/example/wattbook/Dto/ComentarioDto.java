package com.example.wattbook.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class ComentarioDto {
    private Long id;
    private Long usuarioId;
    private String username;
    private Long libroId;
    private String comentario;
    private Date fecha;
}
