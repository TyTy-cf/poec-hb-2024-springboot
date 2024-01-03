package fr.poec.springboot.api;

import fr.poec.springboot.entity.Ingredient;
import fr.poec.springboot.repository.IngredientRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cooking/ingredient")
public class IngredientRestController {

    private IngredientRepository ingredientRepository;

    @GetMapping
    public List<Ingredient> list() {
        return this.ingredientRepository.findAll();
    }

    @GetMapping(path = "/{field}")
    public Optional<Ingredient> show(@PathVariable String field) {
        try {
            Long id = Long.parseLong(field);
            return this.ingredientRepository.findById(id);
        } catch (NumberFormatException e) {
            return this.ingredientRepository.findByNameLike(field);
        }
    }

}
