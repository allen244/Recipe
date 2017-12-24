package com.avs.recipe.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {
    Category category;

    @Before
    public void setUp() throws Exception {
        category = new Category();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getCategoryId() {
        Long idValue= 4l;
        category.setCategoryId(idValue);

        assertEquals(idValue, category.getCategoryId());
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void getRecipes() {
    }
}