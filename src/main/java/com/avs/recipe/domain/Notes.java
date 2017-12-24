package com.avs.recipe.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
@Data
@EqualsAndHashCode(exclude={"recipe"})
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notesId;


    //no cacade because we dont want to delete the recipe
    @OneToOne
    private Recipe recipe;
    @Lob
    private String recipeNotes;



}
