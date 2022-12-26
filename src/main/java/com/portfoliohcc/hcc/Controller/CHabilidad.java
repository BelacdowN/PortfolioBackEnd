package com.portfoliohcc.hcc.Controller;

import com.portfoliohcc.hcc.Entity.Habilidad;
import com.portfoliohcc.hcc.Service.SHabilidad;
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
@RequestMapping("habilidad")
@CrossOrigin(origins = {"https://front-hcc.web.app","https://localhost:4200"})
public class CHabilidad {
    
    @Autowired
    SHabilidad sHabilidad;
    
    @GetMapping ("/lista")
    public ResponseEntity<List<Habilidad>> lista(){
        List<Habilidad> list = sHabilidad.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
     //lista de relojes por id de persona
    @GetMapping ("/persona/{id}/lista")
    public List <Habilidad> listaPer(@PathVariable Long id){
        return sHabilidad.findByPersonaId(id);    
        }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidad> detail(@PathVariable("id") int id){
        Habilidad habilidad = sHabilidad.getOne(id);
        return new ResponseEntity(habilidad, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public void save(@RequestBody Habilidad habi) {
        sHabilidad.save(habi);
    }
    
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable ("id") int id){
        sHabilidad.delete(id);
    }
    
    @PutMapping("/update")
    public void edit(@RequestBody Habilidad habi) {
        sHabilidad.save(habi);
    }
    
    
}
