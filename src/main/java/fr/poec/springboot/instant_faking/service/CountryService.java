package fr.poec.springboot.instant_faking.service;

import fr.poec.springboot.instant_faking.DTO.CountryDTO;
import fr.poec.springboot.instant_faking.entity.Country;
import fr.poec.springboot.instant_faking.exception.NotFoundInstantFakingException;
import fr.poec.springboot.instant_faking.repository.CountryRepository;
import fr.poec.springboot.instant_faking.utils.Slugger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CountryService implements DAOServiceInterface<Country> {

    private CountryRepository countryRepository;

    private Slugger slugger;

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public Optional<Country> findByField(String field) {
        try {
            Long id = Long.parseLong(field);
            return countryRepository.findById(id);
        } catch (NumberFormatException e) {
            return countryRepository.findByNameOrCodeOrSlugOrNationality(field, field, field, field);
        }
    }

    public Country getCountryById(Long id) {
        Optional<Country> optionalCountry = findByField(id.toString());
        if (optionalCountry.isEmpty()) { // on traite l'optional du Country
            throw new NotFoundInstantFakingException("Country", "id", id);
        }
        return optionalCountry.get();
    }

    public Country persist(CountryDTO countryDTO, Long id) {
        if (id != null && countryRepository.findById(id).isEmpty()) {
            throw new NotFoundInstantFakingException(
                "Country", "id", id
            );
        }

        Country country = new Country();
        country.setId(id);
        country.setName(countryDTO.getName());
        country.setNationality(countryDTO.getNationality());
        country.setCode(countryDTO.getCode().toLowerCase());
        country.setSlug(slugger.slugify(countryDTO.getNationality()));
        country.setUrlFlag("https://flagcdn.com/32x24/"+countryDTO.getCode().toLowerCase()+".png");
        return countryRepository.saveAndFlush(country);
    }
}
