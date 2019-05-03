package om.springframework.sfgpetclinic.repositories;

import om.springframework.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
    Owner findByFirstName(String firstName);
    Set<Owner> findAll();
    List<Owner> findAllByLastNameLike(String lastName);


}
