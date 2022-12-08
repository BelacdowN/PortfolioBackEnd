
package com.portfoliohcc.hcc.Repository;

import com.portfoliohcc.hcc.Entity.Red;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RRed extends JpaRepository<Red, Integer>{
    public Optional<Red> findByUrl(String url);
    public boolean existsByUrl (String url);
    
    //toma la lista de los relojes por persona
    List<Red> findByPersonaId(Long personaId);
  
/*@Transactional
    void deleteByPersonaId(Long personaId);*/
  
    
}
