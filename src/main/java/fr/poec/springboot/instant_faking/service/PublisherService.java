package fr.poec.springboot.instant_faking.service;

import fr.poec.springboot.instant_faking.DTO.PublisherDTO;
import fr.poec.springboot.instant_faking.entity.Publisher;
import fr.poec.springboot.instant_faking.repository.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PublisherService {

    private PublisherRepository publisherRepository;

    public List<PublisherDTO> findAll() {
        List<PublisherDTO> dtoList = new ArrayList<>();
        publisherRepository.findAll().forEach(p -> {
            dtoList.add(getDTOFromObjet(p));
        });
        return dtoList;
    }

    private PublisherDTO getDTOFromObjet(Publisher o) {
        return new PublisherDTO(
            o.getName(),
            o.getWebsite(),
            o.getSlug()
        );
    }

    public Optional<Publisher> show(Long id) {
        return publisherRepository.findById(id);
    }
}
