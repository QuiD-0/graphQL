package com.quid.recipe.ingredient.gateway.api

import com.quid.recipe.ingredient.domain.Ingredient
import com.quid.recipe.ingredient.gateway.api.model.request.CreateIngredientRequest
import com.quid.recipe.ingredient.usecase.CreateIngredient
import com.quid.recipe.ingredient.usecase.FindIngredient
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class IngredientController(
    private val findIngredient: FindIngredient,
    private val createIngredient: CreateIngredient,
) {

    @QueryMapping
    fun getIngredients(): List<Ingredient> = findIngredient.all()

    @QueryMapping
    fun findByCode(@Argument code: String): Ingredient = findIngredient.byCode(code)

    @MutationMapping
    fun createIngredient(@Argument request: CreateIngredientRequest): Ingredient = createIngredient.execute(request)
}