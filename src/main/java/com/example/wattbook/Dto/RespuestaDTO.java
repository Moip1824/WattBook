package com.example.wattbook.Dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RespuestaDTO {
    private Integer estado;
    private String token;
    private String mensaje;
    private Object cuerpo;

    public static class SeguidoresDTO {
        private Long usuarioId;
        private Long seguidorId;

        // Getters and setters
        public Long getUsuarioId() {
            return usuarioId;
        }

        public void setUsuarioId(Long usuarioId) {
            this.usuarioId = usuarioId;
        }

        public Long getSeguidorId() {
            return seguidorId;
        }

        public void setSeguidorId(Long seguidorId) {
            this.seguidorId = seguidorId;
        }
    }
}
