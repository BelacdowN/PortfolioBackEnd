
package com.portfoliohcc.hcc.Dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoExperiencia {
    private String puesto;
    private Date inicio;
    private Date fin;   
    private String descripcion;  
    private String imagen;
    private String url;
    private String empresa;
    private boolean esTrabajoActual;

    public DtoExperiencia() {
    }

    public DtoExperiencia(String puesto, Date inicio, Date fin, String descripcion, String imagen, String url, String empresa, boolean esTrabajoActual) {
        this.puesto = puesto;
        this.inicio = inicio;
        this.fin = fin;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.url = url;
        this.empresa = empresa;
        this.esTrabajoActual = esTrabajoActual;
    }

    
}
