
package com.portfoliohcc.hcc.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String proyecto;
    private String inicio;
    private String fin;    
    private String descripcion;    
    private String imagen;
    private String url;

    public Proyecto() {
    }

    public Proyecto(String proyecto, String inicio, String fin, String descripcion, String imagen, String url) {
        this.proyecto = proyecto;
        this.inicio = inicio;
        this.fin = fin;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.url = url;
    }
    
    
}
