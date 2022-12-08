
package com.portfoliohcc.hcc.Controller;

import com.portfoliohcc.hcc.Entity.Experiencia;
import com.portfoliohcc.hcc.Service.SExperiencia;
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
@RequestMapping("Experiencia")
@CrossOrigin(origins = "http://localhost:4200")
public class CExperiencia {
     @Autowired
    SExperiencia sExperiencia;
    
    
    @GetMapping ("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
      //lista de relojes por id de persona
    @GetMapping ("/persona/{id}/lista")
    public List <Experiencia> findByPersonaId(@PathVariable Long id){
        return sExperiencia.findByPersonaId(id);    
        }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        Experiencia expe = sExperiencia.getOne(id);
        return new ResponseEntity(expe, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public void create(@RequestBody Experiencia expe) {      
        sExperiencia.save(expe);
    }
    
      @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable ("id") int id){
        sExperiencia.delete(id);
    }
    
    @PutMapping("/update")
    public void edit(@RequestBody Experiencia expe) {      
        sExperiencia.save(expe);
    }
    
}
