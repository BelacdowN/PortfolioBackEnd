
package com.portfoliohcc.hcc.Entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String proyecto;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date inicio;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fin; 
    
    @Lob //longtext
    private String descripcion;
    
    @Size(max=100)
    private String imagen;
    
    private String url;

    public Proyecto() {
    }

    public Proyecto(String proyecto, Date inicio, Date fin, String descripcion, String imagen, String url) {
        this.proyecto = proyecto;
        this.inicio = inicio;
        this.fin = fin;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.url = url;
    }
    
    
}
