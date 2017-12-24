package com.avs.recipe.repositories;

import com.avs.recipe.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Override
    Optional<Category> findById(Long aLong);

    Optional<Category> findByDescription(String description);
}
