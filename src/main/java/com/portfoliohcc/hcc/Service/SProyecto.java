
package com.portfoliohcc.hcc.Service;

import com.portfoliohcc.hcc.Entity.Proyecto;
import com.portfoliohcc.hcc.Repository.RProyecto;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional//persistencia en base de datos
public class SProyecto {
    
    @Autowired
    RProyecto rProyecto;
    
    public List<Proyecto> list(){
        return rProyecto.findAll();
    }
    
    public Optional<Proyecto> getOne(int id){
        return rProyecto.findById(id);
    }
    
    public Optional<Proyecto> getByProyecto (String proyecto){
        return rProyecto.findByProyecto(proyecto);  
    }
    
    public void save(Proyecto proye){
        rProyecto.save(proye);
    }
    
     public void delete(int id){
        rProyecto.deleteById(id);
    }
    
     public boolean existsById (int id){
         return rProyecto.existsById(id);
     }
     
     public boolean existsByProyecto (String proyecto){
         return rProyecto.existsByProyecto(proyecto);
     }
    
    
}
