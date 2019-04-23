package om.springframework.sfgpetclinic.services;


import om.springframework.sfgpetclinic.model.Pet;
import org.springframework.stereotype.Service;


@Service
public interface PetService extends CrudService<Pet, Long>{


}
