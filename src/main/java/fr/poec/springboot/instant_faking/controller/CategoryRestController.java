package fr.poec.springboot.instant_faking.controller;

import fr.poec.springboot.instant_faking.entity.Category;
import fr.poec.springboot.instant_faking.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/category")
public class CategoryRestController {

    private CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> list() {
        return this.categoryRepository.findAll();
    }

}