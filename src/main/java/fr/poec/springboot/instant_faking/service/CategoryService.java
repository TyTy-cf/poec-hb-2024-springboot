package fr.poec.springboot.instant_faking.service;

import fr.poec.springboot.instant_faking.entity.Category;
import fr.poec.springboot.instant_faking.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService implements DAOServiceInterface<Category> {

    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Optional<Category> findByField(String field) {
        try {
            Long id = Long.parseLong(field);
            return categoryRepository.findById(id);
        } catch (NumberFormatException e) {
            return categoryRepository.findBySlug(field);
        }
    }
}
