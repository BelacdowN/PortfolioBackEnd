
package com.portfoliohcc.hcc.Controller;

import com.portfoliohcc.hcc.Entity.Persona;
import com.portfoliohcc.hcc.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService  IPersonaService;
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersona(){
        return IPersonaService.getPersona() ;
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @Secured("ADMIN")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        IPersonaService.savePersona(persona);
        return "La persona fué creada correctamente";
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @Secured("ADMIN")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        IPersonaService.deletePersona(id);
        return "La persona fué eliminada correctamente";
    }
    
    // URL:PUERTO/personas/editar/4/nombre&apellido&img
    //@PreAuthorize("hasRole('ADMIN')")
    @Secured("ADMIN")
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("apellido") String nuevoApellido,
                                @RequestParam("img") String nuevoImg,
                                @RequestParam("titulo") String nuevoTitulo,
                                @RequestParam("banner") String nuevoBanner,
                                @RequestParam("sobreMi") String nuevoSobreMi){
        Persona persona = IPersonaService.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        persona.setTitulo(nuevoTitulo);
        persona.setBanner(nuevoBanner);
        persona.setSobreMi(nuevoSobreMi);
        
        IPersonaService.savePersona(persona);        
        return persona;
    }
    @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return IPersonaService.findPersona((long)1);
    }
}