package com.avs.recipe.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Scanner;

@Data
@EqualsAndHashCode(exclude={"recipe"})
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingredientId;
    private String description;
    private BigDecimal amount;


    public Ingredient() {
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom) {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
    }


    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom, Recipe recipe) {
        this.description = description;
        this.amount = amount;
        this.recipe = recipe;
        this.uom = uom;
    }

    @ManyToOne
    private Recipe recipe;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure uom;


}
