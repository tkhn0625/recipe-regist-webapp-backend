package com.tkhn0625.rest.restfulwebservices.reciperegistrestfulwebservices.recipe;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@JsonPropertyOrder({
        "cookingName",
        "materials",
        "flow"
})
public class Recipe {
    @JsonProperty("id")
    private long id;
    @JsonProperty("cookingName")
    private String cookingName;
    @JsonProperty("materials")
    private List<Material> materials = null;
    @JsonProperty("flow")
    private List<String> flow = null;
}
