package fr.poec.springboot.api;

import fr.poec.springboot.entity.Recipe;
import fr.poec.springboot.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cooking/recipe")
public class RecipeRestController {

    private RecipeRepository recipeRepository;

    @GetMapping
    public List<Recipe> list() {
        return this.recipeRepository.findAll();
    }

}
