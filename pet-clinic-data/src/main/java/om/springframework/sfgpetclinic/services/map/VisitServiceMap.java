package om.springframework.sfgpetclinic.services.map;

import om.springframework.sfgpetclinic.model.Visit;
import om.springframework.sfgpetclinic.repositories.VisitRepository;
import om.springframework.sfgpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class VisitServiceMap extends AbstractServiceMap<Visit, Long> implements VisitService {

    private final VisitRepository visitRepository;

    public VisitServiceMap(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {

        if (visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null){
            throw new RuntimeException("Invalid Visit.");
        }

        return super.save(visit);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }
}
