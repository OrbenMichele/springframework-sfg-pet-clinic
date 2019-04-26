package om.springframework.sfgpetclinic.repositories;

import om.springframework.sfgpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface VetRepository extends CrudRepository<Vet, Long> {

    Vet findByLastName(String lastName);
    Vet findByFirstName(String firstName);
    Set<Vet> findAll();

}
