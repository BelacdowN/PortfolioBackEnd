
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
    
    public Estudio getOne(int id){
        Estudio expe = rEstudio.findById(id).orElse(null);
        return expe;
    }
    
    public void save(Estudio estu){
        rEstudio.save(estu);
    }
    
     public void delete(int id){
        rEstudio.deleteById(id);
    }
    
    public void edit(Estudio estu){
        rEstudio.save(estu);
    }
    
     //busca lista de relojes por la id de la persona
    public List<Estudio> findByPersonaId(Long personaId) {
        return rEstudio.findByPersonaId(personaId);
    }
    
}
