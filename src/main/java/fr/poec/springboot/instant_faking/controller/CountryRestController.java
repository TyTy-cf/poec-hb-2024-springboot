package fr.poec.springboot.instant_faking.controller;


import fr.poec.springboot.instant_faking.entity.Country;
import fr.poec.springboot.instant_faking.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/country")
public class CountryRestController {

    private CountryRepository countryRepository;

    @GetMapping
    public List<Country> list() {
        return this.countryRepository.findAll();
    }

}