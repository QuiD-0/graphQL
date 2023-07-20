package com.quid.recipe.ingredient.usecase

import com.quid.recipe.ingredient.domain.Ingredient
import com.quid.recipe.ingredient.gateway.repository.IngredientRepository
import org.springframework.stereotype.Service

interface IncreaseQuantity {

    fun increase(code: String, quantity: Int): Ingredient

    @Service
    class IncreaseQuantityUseCase(
    private val ingredientRepository: IngredientRepository
    ) : IncreaseQuantity {
        override fun increase(code: String, quantity: Int) : Ingredient =
            ingredientRepository.findByCode(code)
                .let { it.copy(quantity = it.quantity + quantity) }
                .let { ingredientRepository.save(it) }

    }
}