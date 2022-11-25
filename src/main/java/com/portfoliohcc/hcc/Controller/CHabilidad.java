package com.portfoliohcc.hcc.Controller;

import com.portfoliohcc.hcc.Dto.DtoHabilidad;
import com.portfoliohcc.hcc.Entity.Habilidad;
import com.portfoliohcc.hcc.Security.Controller.Mensaje;
import com.portfoliohcc.hcc.Service.SHabilidad;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("habilidad")
@CrossOrigin(origins = "http://localhost:4200")
public class CHabilidad {
    
    @Autowired
    SHabilidad sHabilidad;
    
    @GetMapping ("/lista")
    public ResponseEntity<List<Habilidad>> list(){
        List<Habilidad> list = sHabilidad.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidad> getById(@PathVariable("id") int id){
        if(!sHabilidad.existsById(id))
            return new ResponseEntity(new Mensaje("La habilidad no existe"), HttpStatus.NOT_FOUND);
        Habilidad habilidad = sHabilidad.getOne(id).get();
        return new ResponseEntity(habilidad, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoHabilidad dtoHab) {
        if (StringUtils.isBlank(dtoHab.getHabilidad())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Habilidad habilidad = new Habilidad(dtoHab.getHabilidad(), dtoHab.getPorcentaje());
        sHabilidad.save(habilidad);
        return new ResponseEntity(new Mensaje("Habilidad creada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable ("id") int id, @RequestBody DtoHabilidad dtoHab){
        if(!sHabilidad.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoHab.getHabilidad())){
            return new ResponseEntity(new Mensaje("El nombre es olbigatorio"), HttpStatus.BAD_REQUEST);
        }
        Habilidad habilidad = sHabilidad.getOne(id).get();
        habilidad.setHabilidad(dtoHab.getHabilidad());
        habilidad.setPorcentaje(dtoHab.getPorcentaje());       
        sHabilidad.save(habilidad);
        return new ResponseEntity(new Mensaje("Habilidad modificada correctamente"), HttpStatus.OK);        
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") int id){
        if(!sHabilidad.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        sHabilidad.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad eliminada correctamente"), HttpStatus.OK);
    }
    
    
}
