
package com.portfoliohcc.hcc.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Estudio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String estudio;
    private String inicio;
    private String fin;    
    private String descripcion;    
    private String imagen;
    private String url;
    private String institucion;

    public Estudio() {
    }

    public Estudio(String estudio, String inicio, String fin, String descripcion, String imagen, String url, String institucion) {
        this.estudio = estudio;
        this.inicio = inicio;
        this.fin = fin;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.url = url;
        this.institucion = institucion;
    }
    
    
}
