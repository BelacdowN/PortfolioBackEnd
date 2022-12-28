
package com.portfoliohcc.hcc.Controller;

import com.portfoliohcc.hcc.Entity.Persona;
import com.portfoliohcc.hcc.Service.ImpPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
//@CrossOrigin(origins = {"https://porfolio-hcc.web.app","http://localhost:4200"})
public class PersonaController {
    
    @Autowired ImpPersonaService  IPersonaService;
    
    @GetMapping ("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = IPersonaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> detail(@PathVariable("id") Long id){
        Persona perso = IPersonaService.getOne(id);
        return new ResponseEntity(perso, HttpStatus.OK);
    }       
    
    
    @PostMapping("/create")
    public void save(@RequestBody Persona persona){
        IPersonaService.save(persona);
    }
    
   
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        IPersonaService.delete(id);
    }
    
    @PutMapping("/update")
    public void edit(@RequestBody Persona persona){
        IPersonaService.edit(persona);
    }
        
   
  
    
}