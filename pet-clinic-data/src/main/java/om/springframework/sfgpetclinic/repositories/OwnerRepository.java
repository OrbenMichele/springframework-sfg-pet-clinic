package om.springframework.sfgpetclinic.repositories;

import om.springframework.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
    Owner findByFirstName(String firstName);
    Set<Owner> findAll();


}
