
package com.portfoliohcc.hcc.Dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class DtoProyecto {
    private String proyecto;
    private Date inicio;
    private Date fin;    
    private String descripcion;    
    private String imagen;
    private String url;

    public DtoProyecto() {
    }

    public DtoProyecto(String proyecto, Date inicio, Date fin, String descripcion, String imagen, String url) {
        this.proyecto = proyecto;
        this.inicio = inicio;
        this.fin = fin;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.url = url;
    }
}
