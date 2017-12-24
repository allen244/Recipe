package com.avs.recipe.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude={"recipes"})
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long categoryId;
    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;


}
