package com.quid.recipe.ingredient.usecase

import com.quid.recipe.ingredient.domain.Ingredient
import com.quid.recipe.ingredient.gateway.api.model.request.CreateIngredientRequest
import com.quid.recipe.ingredient.gateway.repository.IngredientRepository
import org.springframework.stereotype.Service

interface CreateIngredient {

    fun execute(request: CreateIngredientRequest): Ingredient

    @Service
    class CreateIngredientUseCase(
        private val ingredientRepository: IngredientRepository
    ) : CreateIngredient {

        override fun execute(request: CreateIngredientRequest): Ingredient =
            request.toIngredient()
                .let { ingredientRepository.save(it) }
    }
}