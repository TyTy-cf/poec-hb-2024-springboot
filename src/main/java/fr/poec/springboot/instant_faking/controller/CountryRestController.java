package fr.poec.springboot.instant_faking.controller;


import fr.poec.springboot.instant_faking.DTO.CountryDTO;
import fr.poec.springboot.instant_faking.entity.Country;
import fr.poec.springboot.instant_faking.service.CountryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/country")
public class CountryRestController {

    private CountryService countryService;

    @GetMapping
    public List<Country> list() {
        return countryService.findAll();
    }

    @GetMapping(path = "/{field}")
    public Optional<Country> show(@PathVariable String field) {
        return countryService.findByField(field);
    }

    @PostMapping
    public Country create(@Valid @RequestBody CountryDTO countryDTO) {
        return countryService.persist(countryDTO, null);
    }

    @PutMapping("/{id}")
    public Country edit(@Valid @RequestBody CountryDTO countryDTO, @PathVariable Long id) {
        return countryService.persist(countryDTO, id);
    }

}