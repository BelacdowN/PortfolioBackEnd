
package com.portfoliohcc.hcc.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.OneToMany;


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
    
   //relacion y para que borre si la persona no existe
    @OneToMany(mappedBy="persona", cascade=CascadeType.ALL)
    private List<Red> redes; 
    
      //relacion y para que borre si la persona no existe
    @OneToMany(mappedBy="persona", cascade=CascadeType.ALL)
    private List<Proyecto> proyectos; 
    
      //relacion y para que borre si la persona no existe
    @OneToMany(mappedBy="persona", cascade=CascadeType.ALL)
    private List<Habilidad> habilidades; 
    
      //relacion y para que borre si la persona no existe
    @OneToMany(mappedBy="persona", cascade=CascadeType.ALL)
    private List<Estudio> estudios; 
    
      //relacion y para que borre si la persona no existe
    @OneToMany(mappedBy="persona", cascade=CascadeType.ALL)
    private List<Experiencia> experiencias; 

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
        //redes= new ArrayList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSobreMi() {
        return sobreMi;
    }

    public void setSobreMi(String sobreMi) {
        this.sobreMi = sobreMi;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }
    
    @JsonManagedReference
    public List<Red> getRedes() {
        return redes;
    }

    public void setRedes(List<Red> redes) {
        this.redes = redes;
    }
    
    @JsonManagedReference
    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }
     @JsonManagedReference
    public List<Habilidad> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }
     @JsonManagedReference
    public List<Estudio> getEstudios() {
        return estudios;
    }

    public void setEstudios(List<Estudio> estudios) {
        this.estudios = estudios;
    }
     @JsonManagedReference
    public List<Experiencia> getExperiencias() {
        return experiencias;
    }

    public void setExperiencias(List<Experiencia> experiencias) {
        this.experiencias = experiencias;
    }
  
    
    
}
