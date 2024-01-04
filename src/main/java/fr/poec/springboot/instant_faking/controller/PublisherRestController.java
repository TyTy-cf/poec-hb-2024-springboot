package fr.poec.springboot.instant_faking.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.poec.springboot.instant_faking.DTO.PublisherDTO;
import fr.poec.springboot.instant_faking.entity.Publisher;
import fr.poec.springboot.instant_faking.json_views.JsonViews;
import fr.poec.springboot.instant_faking.service.PublisherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/publisher")
public class PublisherRestController {

    private PublisherService publisherService;

    @GetMapping
    public List<PublisherDTO> list() {
        return this.publisherService.findAll();
    }

    @GetMapping(path = "/{id}")
    @JsonView(JsonViews.PublisherShowView.class)
    public Optional<Publisher> show(@PathVariable Long id) {
        return this.publisherService.show(id);
    }

}