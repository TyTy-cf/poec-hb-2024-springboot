package fr.poec.springboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 1024)
    private String description;

    @Column()
    private int preparationTime;

    @Column(scale = 4)
    private int cookingTime;

    @ManyToMany
    private List<Ingredient> ingredients = new ArrayList<>();

}