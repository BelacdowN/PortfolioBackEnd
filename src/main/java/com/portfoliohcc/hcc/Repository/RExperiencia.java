
package com.portfoliohcc.hcc.Repository;

import com.portfoliohcc.hcc.Entity.Experiencia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RExperiencia extends JpaRepository<Experiencia, Integer>{
      //toma la lista de los relojes por persona
    List<Experiencia> findByPersonaId(Long personaId);
}
