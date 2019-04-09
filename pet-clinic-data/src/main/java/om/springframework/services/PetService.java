package om.springframework.services;

import om.springframework.model.Owner;
import om.springframework.model.Pet;

import java.util.Set;

public interface PetService {


    Pet findById(Long id);

    Pet save(Owner owner);

    Set<Pet> findAll();
}
