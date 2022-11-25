
package com.portfoliohcc.hcc.Controller;

import com.portfoliohcc.hcc.Dto.DtoEstudio;
import com.portfoliohcc.hcc.Entity.Estudio;
import com.portfoliohcc.hcc.Security.Controller.Mensaje;
import com.portfoliohcc.hcc.Service.SEstudio;
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
@RequestMapping("estudio")
@CrossOrigin(origins = "http://localhost:4200")
public class CEstudio {
    
    @Autowired
    SEstudio sEstudio;
    
    @GetMapping ("/lista")
    public ResponseEntity<List<Estudio>> list(){
        List<Estudio> list = sEstudio.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Estudio> getById(@PathVariable("id") int id){
        if(!sEstudio.existsById(id))
            return new ResponseEntity(new Mensaje("El estudio no existe"), HttpStatus.NOT_FOUND);
        Estudio estudio = sEstudio.getOne(id).get();
        return new ResponseEntity(estudio, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEstudio dtoEst) {
        if (StringUtils.isBlank(dtoEst.getEstudio())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Estudio estudio = new Estudio(dtoEst.getEstudio(), dtoEst.getInicio(),
                dtoEst.getFin(), dtoEst.getDescripcion(), dtoEst.getImagen(), dtoEst.getUrl(),
                dtoEst.getInstitucion());
        sEstudio.save(estudio);
        return new ResponseEntity(new Mensaje("Estudio creada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable ("id") int id, @RequestBody DtoEstudio dtoEst){
        if(!sEstudio.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoEst.getEstudio())){
            return new ResponseEntity(new Mensaje("El nombre es olbigatorio"), HttpStatus.BAD_REQUEST);
        }
        Estudio estudio = sEstudio.getOne(id).get();
        estudio.setEstudio(dtoEst.getEstudio());
        estudio.setInicio(dtoEst.getInicio());
        estudio.setFin(dtoEst.getFin());
        estudio.setDescripcion(dtoEst.getDescripcion());
        estudio.setImagen(dtoEst.getImagen());
        estudio.setUrl(dtoEst.getUrl());
        estudio.setInstitucion(dtoEst.getInstitucion());
        sEstudio.save(estudio);
        return new ResponseEntity(new Mensaje("Estudio modificada correctamente"), HttpStatus.OK);        
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") int id){
        if(!sEstudio.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        sEstudio.delete(id);
        return new ResponseEntity(new Mensaje("Estudio eliminada correctamente"), HttpStatus.OK);
    }
    
}
