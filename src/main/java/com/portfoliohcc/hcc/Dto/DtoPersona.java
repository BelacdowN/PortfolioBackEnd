
package com.portfoliohcc.hcc.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoPersona {
    
    private String nombre;
    private String apellido;
    private String titulo;    
    private String sobreMi;
    private String banner;
    private String img;
    private String email;
    private String curriculum;

    public DtoPersona() {
    }

    public DtoPersona(String apellido, String titulo, String sobreMi, String banner, String img, String email, String curriculum) {
        this.apellido = apellido;
        this.titulo = titulo;
        this.sobreMi = sobreMi;
        this.banner = banner;
        this.img = img;
        this.email = email;
        this.curriculum = curriculum;
    }
    
    
}
