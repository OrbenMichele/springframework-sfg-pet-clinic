package om.springframework.services;

import om.springframework.model.Owner;
import om.springframework.model.Vet;

import java.util.Set;

public interface VerService {

    Vet findById(Long id);

    Vet save(Owner owner);

    Set<Vet> findAll();
}
