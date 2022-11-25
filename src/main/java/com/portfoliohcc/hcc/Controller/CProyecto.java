
package com.portfoliohcc.hcc.Controller;

import com.portfoliohcc.hcc.Dto.DtoProyecto;
import com.portfoliohcc.hcc.Entity.Proyecto;
import com.portfoliohcc.hcc.Security.Controller.Mensaje;
import com.portfoliohcc.hcc.Service.SProyecto;
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
@RequestMapping("proyecto")
@CrossOrigin(origins = "http://localhost:4200")
public class CProyecto {
    
    @Autowired
    SProyecto sProyecto;
    
    @GetMapping ("/lista")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        if(!sProyecto.existsById(id))
            return new ResponseEntity(new Mensaje("El proyecto no existe"), HttpStatus.NOT_FOUND);
        Proyecto proyecto = sProyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyecto dtoPro) {
        if (StringUtils.isBlank(dtoPro.getProyecto())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Proyecto proyecto = new Proyecto(dtoPro.getProyecto(), dtoPro.getInicio(),
                dtoPro.getFin(), dtoPro.getDescripcion(), dtoPro.getImagen(), dtoPro.getUrl());
        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto creada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable ("id") int id, @RequestBody DtoProyecto dtoPro){
        if(!sProyecto.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoPro.getProyecto())){
            return new ResponseEntity(new Mensaje("El nombre es olbigatorio"), HttpStatus.BAD_REQUEST);
        }
        Proyecto proyecto = sProyecto.getOne(id).get();
        proyecto.setProyecto(dtoPro.getProyecto());
        proyecto.setInicio(dtoPro.getInicio());
        proyecto.setFin(dtoPro.getFin());
        proyecto.setDescripcion(dtoPro.getDescripcion());
        proyecto.setImagen(dtoPro.getImagen());
        proyecto.setUrl(dtoPro.getUrl());
        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto modificada correctamente"), HttpStatus.OK);        
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") int id){
        if(!sProyecto.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        sProyecto.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminada correctamente"), HttpStatus.OK);
    }
    
    
}
