package com.tkhn0625.rest.restfulwebservices.reciperegistrestfulwebservices.recipe;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecipeManagementService {

    private static final List<Recipe> recipes = new ArrayList<>();
    private static long idCounter = 0;
    static {
        recipes.add(new Recipe(++idCounter,"carry",
                new ArrayList<Material>(Arrays.asList(
                        new Material("potato", "4"),
                        new Material("carrot","1")
                )),
                new ArrayList<String>(Arrays.asList("voil","fly"))));
        recipes.add(new Recipe(++idCounter,"唐揚げ",
                new ArrayList<Material>(Arrays.asList(
                        new Material("鶏肉", "400g"),
                        new Material("小麦粉","10g"),
                        new Material("醤油","大1")
                )),
                new ArrayList<String>(Arrays.asList("醤油に鶏肉を25分間つける","小麦粉をまぶす","揚げる"))));
    }

    public List<Recipe> findAll(){return recipes;}

    public Recipe save(Recipe recipe){
        if(recipe.getId()==-1 || recipe.getId()==0){
            recipe.setId(++idCounter);
            recipes.add(recipe);
        }else {
            deleteById(recipe.getId());
            recipes.add(recipe);
        }
        return null;
    }

    public Recipe findById(long id){
        for(Recipe recipe:recipes){
            if(recipe.getId()==id){
                return recipe;
            }
        }
        return null;
    }

    public Recipe deleteById(long id){
        Recipe recipe = findById(id);
        if(recipe==null){
            return null;
        }
        if (recipes.remove(recipe)){
            return recipe;
        }
        return null;
    }

}
