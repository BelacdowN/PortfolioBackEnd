
package com.portfoliohcc.hcc.Security.Repository;

import com.portfoliohcc.hcc.Security.Entity.Rol;
import com.portfoliohcc.hcc.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
