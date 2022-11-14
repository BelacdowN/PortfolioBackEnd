
package com.portfoliohcc.hcc.Repository;

import com.portfoliohcc.hcc.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RExperiencia extends JpaRepository<Experiencia, Integer>{
    public Optional<Experiencia> findByPuesto (String puesto);
    public boolean existsByPuesto (String puesto);
}
