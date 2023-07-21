package com.quid.recipe.menu.domain

import org.bson.types.ObjectId

data class Menu(
    val id: String = ObjectId.get().toHexString(),
    val name: String,
    val ingredientCodes: List<String> = listOf(),
    val price: Int
) {
    init {
        require(name.isNotEmpty()) { "name is must not null" }
    }
}