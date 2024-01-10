package fr.poec.springboot.instant_faking.service;

import fr.poec.springboot.instant_faking.DTO.PlatformDTO;
import fr.poec.springboot.instant_faking.entity.Country;
import fr.poec.springboot.instant_faking.entity.Platform;
import fr.poec.springboot.instant_faking.exception.NotFoundInstantFakingException;
import fr.poec.springboot.instant_faking.repository.PlatformRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlatformService implements DAOServiceInterface<Platform> {

    private PlatformRepository platformRepository;

    @Override
    public List<Platform> findAll() {
        return platformRepository.findAll();
    }

    public Platform persist(PlatformDTO platformDTO, Long id) {
        if (id != null && platformRepository.findById(id).isEmpty()) {
            throw new NotFoundInstantFakingException(
                    "Platform", "id", id
            );
        }

        Platform pf = new Platform();
        pf.setId(id);
        pf.setName(platformDTO.getName());
        return platformRepository.saveAndFlush(pf);
    }

    public Optional<Platform> findByField(String field) {
        try {
            Long id = Long.parseLong(field);
            return platformRepository.findById(id);
        } catch (NumberFormatException e) {
            return platformRepository.findByName(field);
        }
    }
}
