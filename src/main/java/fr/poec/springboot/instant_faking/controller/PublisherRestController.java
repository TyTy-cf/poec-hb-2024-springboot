package fr.poec.springboot.instant_faking.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.poec.springboot.instant_faking.DTO.PublisherDTO;
import fr.poec.springboot.instant_faking.entity.Publisher;
import fr.poec.springboot.instant_faking.exception.NotFoundInstantFakingException;
import fr.poec.springboot.instant_faking.json_views.JsonViews;
import fr.poec.springboot.instant_faking.service.PublisherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/publisher")
public class PublisherRestController {

    private PublisherService publisherService;

    @GetMapping
    public List<PublisherDTO> list() {
        return publisherService.findAll();
    }

    @GetMapping(path = "/{id}")
    @JsonView(JsonViews.PublisherShowView.class)
    public Publisher show(@PathVariable Long id) {
        Optional<Publisher> publisherOptional = publisherService.show(id);
        if (publisherOptional.isPresent()) {
            return publisherOptional.get();
        }
        throw new NotFoundInstantFakingException("Publisher", "id", id);
    }

}