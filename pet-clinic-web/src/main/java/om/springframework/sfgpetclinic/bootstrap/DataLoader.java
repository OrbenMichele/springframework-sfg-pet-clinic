package om.springframework.sfgpetclinic.bootstrap;


import om.springframework.sfgpetclinic.model.Owner;
import om.springframework.sfgpetclinic.model.Pet;
import om.springframework.sfgpetclinic.model.PetType;
import om.springframework.sfgpetclinic.model.Vet;
import om.springframework.sfgpetclinic.services.OwnerService;
import om.springframework.sfgpetclinic.services.PetTypeService;
import om.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {


    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {


        PetType dog = new PetType();
        dog.setName("Dog 1");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat 1");
        PetType saveCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("Address Michael");
        owner1.setCity("NY");
        owner1.setTelephone("123-1234");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(saveDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Prince");
        owner1.getPets().add(mikesPet);
        //owner1.setPets((Set<Pet>) mikesPet);


        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenn");
        owner2.setAddress("Address Fiona");
        owner2.setCity("Boston");
        owner2.setTelephone("234-2345");

        Pet fionasPet = new Pet();
        fionasPet.setPetType(saveCatPetType);
        fionasPet.setOwner(owner1);
        fionasPet.setBirthDate(LocalDate.now());
        fionasPet.setName("Julie");
        owner2.getPets().add(fionasPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Bia");
        vet2.setLastName("Pera");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
