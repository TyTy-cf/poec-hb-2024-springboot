package fr.poec.springboot.instant_faking.controller;

import fr.poec.springboot.instant_faking.entity.Category;
import fr.poec.springboot.instant_faking.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/category")
public class CategoryRestController {

    private CategoryService categoryService;

    @GetMapping
    public List<Category> list() {
        return this.categoryService.findAll();
    }

    @GetMapping(path = "/{field}")
    public Optional<Category> show(@PathVariable String field) {
        return categoryService.findByField(field);
    }

}