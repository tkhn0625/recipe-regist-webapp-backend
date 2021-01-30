package com.tkhn0625.rest.restfulwebservices.reciperegistrestfulwebservices;

import com.tkhn0625.rest.restfulwebservices.reciperegistrestfulwebservices.recipe.Recipe;
import com.tkhn0625.rest.restfulwebservices.reciperegistrestfulwebservices.repository.RecipeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeJpaResource {

    @Autowired
    private RecipeJpaRepository recipeJpaService;

    @GetMapping("/jpa/users/{username}/recipes")
    public List<Recipe> getAllRecipes(@PathVariable String username){
        return recipeJpaService.findByUsername(username);
    }

    @GetMapping("/jpa/users/{username}/recipes/{id}")
    public Recipe getTodo(@PathVariable String username,@PathVariable long id){
        return recipeJpaService.findById(id).get();
    }

    @DeleteMapping("/jpa/users/{username}/recipes/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable String username,@PathVariable long id){
        recipeJpaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //Edit/Update a Recipe
    @PutMapping("/jpa/users/{username}/recipes/{id}")
    public ResponseEntity<Recipe> updateRecipe(
            @PathVariable String username, @PathVariable long id,@RequestBody Recipe recipe){

        Recipe updatedRecipe = recipeJpaService.save(recipe);
        return new ResponseEntity<Recipe>(recipe, HttpStatus.OK);
    }

//    @PostMapping("/jpa/users/{username}/recipes")
//    public ResponseEntity<Void> createRecipe(@PathVariable String username,@RequestBody Recipe recipe){
//
//        Recipe createdRecipe = recipeJpaService.save(recipe);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}").buildAndExpand(createdRecipe.getId()).toUri();
//        return ResponseEntity.created(uri).build();
//    }
}
