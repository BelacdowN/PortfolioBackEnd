
package com.portfoliohcc.hcc.Repository;

import com.portfoliohcc.hcc.Entity.Estudio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REstudio extends JpaRepository<Estudio, Integer>{
    
      //toma la lista de los relojes por persona
    List<Estudio> findByPersonaId(Long personaId);
}
