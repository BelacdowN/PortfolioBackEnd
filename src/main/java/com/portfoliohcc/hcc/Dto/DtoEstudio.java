
package com.portfoliohcc.hcc.Dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class DtoEstudio {
    private String estudio;
    private Date inicio;
    private Date fin;    
    private String descripcion;    
    private String imagen;
    private String url;
    private String institucion;

    public DtoEstudio() {
    }

    public DtoEstudio(String estudio, Date inicio, Date fin, String descripcion, String imagen, String url, String institucion) {
        this.estudio = estudio;
        this.inicio = inicio;
        this.fin = fin;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.url = url;
        this.institucion = institucion;
    }
}
