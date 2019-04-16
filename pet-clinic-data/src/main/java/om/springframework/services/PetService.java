package om.springframework.services;


import om.springframework.model.Pet;
import org.springframework.stereotype.Service;


@Service
public interface PetService extends CrudService<Pet, Long>{


}
