package com.quid.recipe.ingredient.gateway.api

import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class IngredientController {

    @QueryMapping
    fun helloWorld(): String = "Hello World"
}