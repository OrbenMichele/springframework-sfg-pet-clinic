package om.springframework.sfgpetclinic.services.map;

import om.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    final Long ownerId = 1L;
    final String lastName = "Orben";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());

        ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());

    }

    @Test
    void findAll() {

        Set<Owner> owners= ownerServiceMap.findAll();

        assertEquals(1, owners.size());

    }

    @Test
    void findById() {

        Owner owner = ownerServiceMap.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner owner = Owner.builder().id(id).build();
        Owner savedOwner = ownerServiceMap.save(owner);
        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        //Long id = 2L;
        Owner owner = Owner.builder().build();
        Owner savedOwner = ownerServiceMap.save(owner);
        //assertEquals(id, savedOwner.getId());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {

        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0, ownerServiceMap.findAll().size());
        assertNull(ownerServiceMap.findById(ownerId));

    }

    @Test
    void deleteById() {

        ownerServiceMap.deleteById(ownerId);
        assertEquals(0, ownerServiceMap.findAll().size());
        assertNull( ownerServiceMap.findById(ownerId));

    }

    @Test
    void findByLastName() {

        Owner owner = ownerServiceMap.findByLastName(lastName);
        assertNotNull(owner);
        assertEquals(ownerId, owner.getId());

    }

    @Test
    void findByLastNameNotFound() {

        Owner owner = ownerServiceMap.findByLastName("Orbennnn");
        assertNull(owner);

    }
}