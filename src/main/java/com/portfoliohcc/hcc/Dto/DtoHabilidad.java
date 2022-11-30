
package com.portfoliohcc.hcc.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class DtoHabilidad {
    private String habilidad;
    private int porcentaje;

    public DtoHabilidad() {
    }

    public DtoHabilidad(String habilidad, int porcentaje) {
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
    }
}
