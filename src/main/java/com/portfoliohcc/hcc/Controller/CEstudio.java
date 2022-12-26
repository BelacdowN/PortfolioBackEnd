
package com.portfoliohcc.hcc.Controller;

import com.portfoliohcc.hcc.Entity.Estudio;
import com.portfoliohcc.hcc.Service.SEstudio;
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
@RequestMapping("estudio")
@CrossOrigin(origins = {"https://front-hcc.web.app","https://localhost:4200"})
public class CEstudio {
    @Autowired
    SEstudio sEstudio;
    
    
    @GetMapping ("/lista")
    public ResponseEntity<List<Estudio>> list(){
        List<Estudio> list = sEstudio.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
      //lista de relojes por id de persona
    @GetMapping ("/persona/{id}/lista")
    public List <Estudio> listaPer(@PathVariable Long id){
        return sEstudio.findByPersonaId(id);    
        }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Estudio> detail(@PathVariable("id") int id){
        Estudio estu = sEstudio.getOne(id);
        return new ResponseEntity(estu, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public void save(@RequestBody Estudio estu) {      
        sEstudio.save(estu);
    }
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable ("id") int id){
        sEstudio.delete(id);
    }
    
    @PutMapping("/update")
    public void edit(@RequestBody Estudio estu) {      
        sEstudio.save(estu);
    }
}
