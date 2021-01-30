package com.tkhn0625.rest.restfulwebservices.reciperegistrestfulwebservices;

import com.tkhn0625.rest.restfulwebservices.reciperegistrestfulwebservices.recipe.Recipe;
import com.tkhn0625.rest.restfulwebservices.reciperegistrestfulwebservices.recipe.RecipeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class RecipeResource {

    @Autowired
    private RecipeManagementService recipeService;

    @GetMapping("/users/{username}/recipes")
    public List<Recipe> getAllRecipes(@PathVariable String username){return recipeService.findAll();}

    @GetMapping("/users/{username}/recipes/{id}")
    public Recipe getTodo(@PathVariable String username,@PathVariable long id){
        return recipeService.findById(id);
    }

    @DeleteMapping("/users/{username}/recipes/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable String username,@PathVariable long id){
        Recipe recipe = recipeService.deleteById(id);
        if(recipe!=null){
            return ResponseEntity.noContent().build();
        }
        return  ResponseEntity.notFound().build();
    }

    //Edit/Update a Recipe
    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Recipe> updateRecipe(
            @PathVariable String username,@PathVariable long id,@RequestBody Recipe recipe){
        Recipe updateRecipe = recipeService.save(recipe);
        return new ResponseEntity<Recipe>(recipe, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Void> createRecipe(
            @PathVariable String username,@RequestBody Recipe recipe){
        Recipe createdRecipe = recipeService.save(recipe);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdRecipe.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
