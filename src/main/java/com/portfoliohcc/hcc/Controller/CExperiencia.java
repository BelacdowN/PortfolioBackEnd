
package com.portfoliohcc.hcc.Controller;


import com.portfoliohcc.hcc.Dto.DtoExperiencia;
import com.portfoliohcc.hcc.Entity.Experiencia;
import com.portfoliohcc.hcc.Security.Controller.Mensaje;
import com.portfoliohcc.hcc.Service.SExperiencia;
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
@RequestMapping("experiencia")
@CrossOrigin(origins = "http://localhost:4200")
public class CExperiencia {
    @Autowired
    SExperiencia sExperiencia;
    
    @GetMapping ("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("La experiencia no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoExp) {
        if (StringUtils.isBlank(dtoExp.getPuesto())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Experiencia experiencia = new Experiencia(dtoExp.getPuesto(), dtoExp.getInicio(),
                dtoExp.getFin(), dtoExp.getDescripcion(), dtoExp.getImagen(), dtoExp.getUrl(),
                dtoExp.getEmpresa(), dtoExp.isEsTrabajoActual());
        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia creada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable ("id") int id, @RequestBody DtoExperiencia dtoExp){
        if(!sExperiencia.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoExp.getPuesto())){
            return new ResponseEntity(new Mensaje("El nombre es olbigatorio"), HttpStatus.BAD_REQUEST);
        }
        Experiencia experiencia = sExperiencia.getOne(id).get();
        experiencia.setPuesto(dtoExp.getPuesto());
        experiencia.setInicio(dtoExp.getInicio());
        experiencia.setFin(dtoExp.getFin());
        experiencia.setDescripcion(dtoExp.getDescripcion());
        experiencia.setImagen(dtoExp.getImagen());
        experiencia.setUrl(dtoExp.getUrl());
        experiencia.setEmpresa(dtoExp.getEmpresa());
        experiencia.setEsTrabajoActual(dtoExp.isEsTrabajoActual());
        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia modificada correctamente"), HttpStatus.OK);        
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") int id){
        if(!sExperiencia.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        sExperiencia.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada correctamente"), HttpStatus.OK);
    }
}
