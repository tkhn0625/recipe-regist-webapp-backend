
package com.tkhn0625.rest.restfulwebservices.reciperegistrestfulwebservices.recipe;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonPropertyOrder({
        "name",
        "amount"
})
@Setter
@Getter
@AllArgsConstructor
public class Material {

    @JsonProperty("name")
    private String name;

    @JsonProperty("amount")
    private String amount;
}
