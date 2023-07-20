package com.quid.recipe.ingredient.gateway.api.model.request

import com.quid.recipe.ingredient.domain.Ingredient
import com.quid.recipe.ingredient.domain.UnitType

data class CreateIngredientRequest(
    val name: String,
    val code: String,
    val quantity: Int,
    val unit: UnitType,
    val savePoint: String,
) {
    fun toIngredient(): Ingredient = Ingredient(
        name = name,
        code = code,
        quantity = quantity,
        unit = unit,
        savePoint = savePoint,
    )
}