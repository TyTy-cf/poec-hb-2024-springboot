package fr.poec.springboot.courses.repository;

import fr.poec.springboot.courses.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findAllByNameIsContainingIgnoreCase(String name);

    Optional<Ingredient> findByNameLike(String name);

}
