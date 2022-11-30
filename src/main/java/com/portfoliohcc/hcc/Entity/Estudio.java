
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

@Entity
@Getter @Setter
public class Estudio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String estudio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date inicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fin; 
    @Lob
    private String descripcion;    
    private String imagen;
    private String url;
    private String institucion;

    public Estudio() {
    }

    public Estudio(String estudio, Date inicio, Date fin, String descripcion, String imagen, String url, String institucion) {
        this.estudio = estudio;
        this.inicio = inicio;
        this.fin = fin;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.url = url;
        this.institucion = institucion;
    }

   

   
    
}
