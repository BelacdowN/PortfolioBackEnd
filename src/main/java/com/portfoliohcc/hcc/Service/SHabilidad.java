
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
    
    public Optional<Habilidad> getOne(int id){
        return rHabilidad.findById(id);
    }
    
    public Optional<Habilidad> getByHabilidad (String habilidad){
        return rHabilidad.findByHabilidad(habilidad);  
    }
    
    public void save(Habilidad habi){
        rHabilidad.save(habi);
    }
    
     public void delete(int id){
        rHabilidad.deleteById(id);
    }
    
     public boolean existsById (int id){
         return rHabilidad.existsById(id);
     }
     
     public boolean existsByHabilidad (String habilidad){
         return rHabilidad.existsByHabilidad(habilidad);
     }
    
}
