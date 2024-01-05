package fr.poec.springboot.instant_faking.service;

import fr.poec.springboot.instant_faking.entity.Platform;
import fr.poec.springboot.instant_faking.repository.PlatformRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlatformService implements DAOServiceInterface<Platform> {

    private PlatformRepository platformRepository;

    @Override
    public List<Platform> findAll() {
        return platformRepository.findAll();
    }

}
