package com.quid.recipe.menu.domain

import com.quid.recipe.ingredient.domain.Ingredient
import org.bson.types.ObjectId

class Menu(
    val id: String = ObjectId.get().toHexString(),
    val name: String,
    val ingredients: List<Ingredient>,
    val price: Int,
    val description: String,
)