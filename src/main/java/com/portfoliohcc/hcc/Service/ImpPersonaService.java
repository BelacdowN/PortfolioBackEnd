
package com.portfoliohcc.hcc.Service;

import com.portfoliohcc.hcc.Entity.Persona;
import com.portfoliohcc.hcc.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpPersonaService  {
    @Autowired IPersonaRepository rPersona;
    
    
   public List<Persona> list(){
        return rPersona.findAll();
    }
    
    public Optional<Persona> getOne(Long id){
        return rPersona.findById(id);
    }
    
    public Optional<Persona> getByNombre (String nombre){
        return rPersona.findByNombre(nombre);  
    }
    
    public void save(Persona pers){
        rPersona.save(pers);
    }  
    
    
     public void delete(Long id){
        rPersona.deleteById(id);
    }
    
     public boolean existsById (Long id){
         return rPersona.existsById(id);
     }
     
     public boolean existsByNombre (String nombre){
         return rPersona.existsByNombre(nombre);
     }
   
    
}
