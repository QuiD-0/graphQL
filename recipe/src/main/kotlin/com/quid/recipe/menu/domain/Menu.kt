package com.quid.recipe.menu.domain

import com.quid.recipe.ingredient.domain.Ingredient
import org.bson.types.ObjectId

data class Menu(
    val id: String = ObjectId.get().toHexString(),
    val name: String,
    val ingredients: List<Ingredient> = listOf(),
    val price: Int
) {
    init {
        require(name.isNotEmpty()) { "name is must not null" }
    }
}