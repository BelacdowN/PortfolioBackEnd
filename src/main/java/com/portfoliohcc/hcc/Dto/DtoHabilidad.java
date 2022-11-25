
package com.portfoliohcc.hcc.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class DtoHabilidad {
    private String habilidad;
    private String porcentaje;

    public DtoHabilidad() {
    }

    public DtoHabilidad(String habilidad, String porcentaje) {
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
    }
}
