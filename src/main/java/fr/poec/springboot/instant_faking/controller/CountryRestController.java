package fr.poec.springboot.instant_faking.controller;


import fr.poec.springboot.instant_faking.entity.Country;
import fr.poec.springboot.instant_faking.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(path = "/{id}")
    public Optional<Country> show(@PathVariable Long id) {
        return countryService.findById(id);
    }

}