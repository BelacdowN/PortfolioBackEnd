
package com.portfoliohcc.hcc.Security.Service;

import com.portfoliohcc.hcc.Security.Entity.Rol;
import com.portfoliohcc.hcc.Security.Enums.RolNombre;
import com.portfoliohcc.hcc.Security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getbyRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        irolRepository.save(rol);
    }
}
