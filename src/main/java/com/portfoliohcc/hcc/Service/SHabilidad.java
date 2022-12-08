
package com.portfoliohcc.hcc.Service;

import com.portfoliohcc.hcc.Entity.Habilidad;
import com.portfoliohcc.hcc.Repository.RHabilidad;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional//persistencia en base de datos
public class SHabilidad {
    
    
    @Autowired
    RHabilidad rHabilidad;
    
    public List<Habilidad> list(){
        return rHabilidad.findAll();
    }
    
    public Habilidad getOne(int id){
        return rHabilidad.findById(id).orElse(null);
    }
        
    
    public void save(Habilidad habi){
        rHabilidad.save(habi);
    }
    
     public void delete(int id){
        rHabilidad.deleteById(id);
    }
    
     public void edit(Habilidad habi){
        rHabilidad.save(habi);
    }
    
     //busca lista de relojes por la id de la persona
    public List<Habilidad> findByPersonaId(Long personaId) {
        return rHabilidad.findByPersonaId(personaId);
    }
}
