package com.chloe.chloeback.service;

import java.util.List;
//import java.util.Optional;
import java.util.UUID;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chloe.chloeback.exception.UserNotFoundException;
import com.chloe.chloeback.model.Vestido;
import com.chloe.chloeback.repo.VestidoRepo;


//import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.chloe.chloeback.repo.VestidoRepo;




@Transactional
@Service
public class VestidoService {
    private final VestidoRepo vestidoRepo;
 //@Autowired
    public VestidoService(VestidoRepo vestidoRepo) {
        this.vestidoRepo = vestidoRepo;
    }

    public Vestido addVestido(Vestido vestido) {
        
        return vestidoRepo.save(vestido);
    }

    public List<Vestido> findAllVestidos() {
        return vestidoRepo.findAll();
    }

    public Vestido updateVestido(Vestido vestido) {
        return vestidoRepo.save(vestido);
    }

    public Vestido findVestidoById(Long id) {
        return vestidoRepo.findVestidoById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteVestido(Long id){
        vestidoRepo.deleteById(id);
    }
 
    public List<Vestido> searchVestidos(String key) {
        return vestidoRepo.findByNombreContainingOrColorContainingOrTalleContainingOrDescripcionContaining(key, key, key, key);
    
   

}
}

