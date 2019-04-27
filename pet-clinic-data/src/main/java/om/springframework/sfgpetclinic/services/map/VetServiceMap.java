package om.springframework.sfgpetclinic.services.map;

import om.springframework.sfgpetclinic.model.Specialty;
import om.springframework.sfgpetclinic.model.Vet;
import om.springframework.sfgpetclinic.services.SpecialtyService;
import om.springframework.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class VetServiceMap extends AbstractServiceMap<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {


        if (object.getSpecialties().size() > 0){
            object.getSpecialties().forEach(speciality -> {
                if (speciality.getId() == null) {
                    Specialty saveSpecialty = specialtyService.save(speciality);
                    speciality.setId(saveSpecialty.getId());
                }
            });
        }
        return super.save( object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}