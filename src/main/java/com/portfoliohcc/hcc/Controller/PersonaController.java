
package com.portfoliohcc.hcc.Controller;

import com.portfoliohcc.hcc.Dto.DtoPersona;
import com.portfoliohcc.hcc.Entity.Persona;
import com.portfoliohcc.hcc.Security.Controller.Mensaje;
import com.portfoliohcc.hcc.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired ImpPersonaService  IPersonaService;
    
    @GetMapping ("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = IPersonaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
     @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") Long id){
        if(!IPersonaService.existsById(id))
            return new ResponseEntity(new Mensaje("La persona no existe"), HttpStatus.NOT_FOUND);
        Persona perso = IPersonaService.getOne(id).get();
        return new ResponseEntity(perso, HttpStatus.OK);
    }
    
    /*@GetMapping("/traer")
    public List<Persona> getPersona(){
        return IPersonaService.getPersona() ;
    }*/
    
    //@PreAuthorize("hasRole('ADMIN')")
    @Secured("ADMIN")
    @PostMapping("/crear")
    public String createPersona(@RequestBody Persona persona){
        IPersonaService.save(persona);
        return "La persona fué creada correctamente";
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @Secured("ADMIN")
    @DeleteMapping("/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        IPersonaService.delete(id);
        return "La persona fué eliminada correctamente";
    }
    
    // URL:PUERTO/personas/editar/4/nombre&apellido&img
    //@PreAuthorize("hasRole('ADMIN')")
    /*@Secured("ADMIN")
    @PutMapping("/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("apellido") String nuevoApellido,
                                @RequestParam("img") String nuevoImg,
                                @RequestParam("titulo") String nuevoTitulo,
                                @RequestParam("banner") String nuevoBanner,
                                @RequestParam("sobreMi") String nuevoSobreMi){
        Persona persona = IPersonaService.(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        persona.setTitulo(nuevoTitulo);
        persona.setBanner(nuevoBanner);
        persona.setSobreMi(nuevoSobreMi);
        
        IPersonaService.savePersona(persona);        
        return persona;
    }*/
    
     @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable ("id") Long id, @RequestBody DtoPersona dtoExp){
        if(!IPersonaService.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoExp.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Persona perso = IPersonaService.getOne(id).get();
        perso.setNombre(dtoExp.getNombre());
        perso.setApellido(dtoExp.getApellido());
        perso.setImg(dtoExp.getImg());
        perso.setBanner(dtoExp.getBanner());
        perso.setEmail(dtoExp.getEmail());
        perso.setSobreMi(dtoExp.getSobreMi());
        perso.setCurriculum(dtoExp.getCurriculum());
        perso.setTitulo(dtoExp.getTitulo());
        IPersonaService.save(perso);
        return new ResponseEntity(new Mensaje("Persona modificada"), HttpStatus.OK);        
    }
    
    
    /*@GetMapping("/traer/perfil")
    public Persona findPersona(){
        return IPersonaService.findPersona((long)1);
    }*/
}