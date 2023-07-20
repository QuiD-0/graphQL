package com.quid.recipe.ingredient.usecase

import com.quid.recipe.ingredient.domain.Ingredient
import com.quid.recipe.ingredient.repository.IngredientRepository
import org.springframework.stereotype.Service

interface FindIngredient {
    fun all(): List<Ingredient>
    fun byCode(code: String): Ingredient

    @Service
    class FindIngredientUseCase(
        private val ingredientRepository: IngredientRepository
    ) : FindIngredient {

        override fun all(): List<Ingredient> =
            ingredientRepository.findAll()

        override fun byCode(code: String): Ingredient =
            ingredientRepository.findByCode(code)
    }
}