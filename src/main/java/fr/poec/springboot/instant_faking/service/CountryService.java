package fr.poec.springboot.instant_faking.service;

import fr.poec.springboot.instant_faking.entity.Country;
import fr.poec.springboot.instant_faking.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CountryService {

    private CountryRepository countryRepository;

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public Optional<Country> findByField(String field) {
        try {
            Long id = Long.parseLong(field);
            return countryRepository.findById(id);
        } catch (NumberFormatException e) {
            return countryRepository.findBySlug(field);
        }
    }
}
