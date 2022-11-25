
package com.portfoliohcc.hcc.Service;

import com.portfoliohcc.hcc.Entity.Estudio;
import com.portfoliohcc.hcc.Repository.REstudio;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional//persistencia en base de datos
public class SEstudio {
    
    @Autowired
    REstudio rEstudio;
    
    public List<Estudio> list(){
        return rEstudio.findAll();
    }
    
    public Optional<Estudio> getOne(int id){
        return rEstudio.findById(id);
    }
    
    public Optional<Estudio> getByTitulo (String titulo){
        return rEstudio.findByTitulo(titulo);  
    }
    
    public void save(Estudio estu){
        rEstudio.save(estu);
    }
    
     public void delete(int id){
        rEstudio.deleteById(id);
    }
    
     public boolean existsById (int id){
         return rEstudio.existsById(id);
     }
     
     public boolean existsByTitulo (String titulo){
         return rEstudio.existsByTitulo(titulo);
     }
    
}
