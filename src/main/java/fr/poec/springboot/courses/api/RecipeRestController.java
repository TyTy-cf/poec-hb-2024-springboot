package fr.poec.springboot.courses.api;

import fr.poec.springboot.courses.entity.Recipe;
import fr.poec.springboot.courses.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api-v2/recipe")
public class RecipeRestController {

    private RecipeRepository recipeRepository;

    @GetMapping
    public List<Recipe> list() {
        return this.recipeRepository.findAll();
    }

}
