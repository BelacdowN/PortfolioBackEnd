
package com.portfoliohcc.hcc.Repository;

import com.portfoliohcc.hcc.Entity.Estudio;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REstudio extends JpaRepository<Estudio, Integer>{
    public Optional<Estudio> findByTitulo (String titulo);
    public boolean existsByTitulo (String titulo);
}
