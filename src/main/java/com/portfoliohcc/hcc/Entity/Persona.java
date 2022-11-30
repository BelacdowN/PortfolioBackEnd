
package com.portfoliohcc.hcc.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 40, message = "no cumple con la longitud")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 40, message = "no cumple con la longitud")
    private String apellido;
    
    @NotNull
    @Size(min = 1, max = 40, message = "no cumple con la longitud")
    private String titulo;
    
    @Lob
    @NotNull
    @Size(min = 50, max = 5000, message = "no cumple con la longitud")
    private String sobreMi;
    
    @Size(min = 1, max = 400, message = "no cumple con la longitud")
    private String banner;
    
    @Size(min = 1, max = 400, message = "no cumple con la longitud")
    private String img;
    
    @Size(min = 1, max = 400, message = "no cumple con la longitud")
    private String email;
    
    @Size(min = 1, max = 400, message = "no cumple con la longitud")
    private String curriculum;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String titulo, String sobreMi, String banner, String img, String email, String curriculum) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.sobreMi = sobreMi;
        this.banner = banner;
        this.img = img;
        this.email = email;
        this.curriculum = curriculum;
    }
    
    
    
}
