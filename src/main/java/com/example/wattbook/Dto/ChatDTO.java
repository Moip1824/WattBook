package com.example.wattbook.Dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class ChatDTO {
    private Long id;
    private String descripcion;
    private String imagen;
    private String nombre;
    private Long libroId;

}
