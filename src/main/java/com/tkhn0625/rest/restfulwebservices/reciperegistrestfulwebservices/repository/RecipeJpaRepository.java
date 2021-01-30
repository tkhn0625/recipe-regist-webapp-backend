package com.tkhn0625.rest.restfulwebservices.reciperegistrestfulwebservices.repository;

import com.tkhn0625.rest.restfulwebservices.reciperegistrestfulwebservices.recipe.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeJpaRepository extends JpaRepository<Recipe,Long> {
    List<Recipe> findByUsername(String username);
}
