
package com.portfoliohcc.hcc.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class DtoProyecto {
    private String proyecto;
    private String inicio;
    private String fin;    
    private String descripcion;    
    private String imagen;
    private String url;

    public DtoProyecto() {
    }

    public DtoProyecto(String proyecto, String inicio, String fin, String descripcion, String imagen, String url) {
        this.proyecto = proyecto;
        this.inicio = inicio;
        this.fin = fin;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.url = url;
    }
}
