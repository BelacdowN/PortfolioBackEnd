
package com.portfoliohcc.hcc.Entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String puesto;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date inicio;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fin; 
    
    @Lob   
    private String descripcion;
    
    private String imagen;
    
    private String url;
    
    private String empresa;
    private boolean esTrabajoActual;

    public Experiencia() {
    }

    public Experiencia(String puesto, Date inicio, Date fin, String descripcion, String imagen, String url, String empresa, boolean esTrabajoActual) {
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
