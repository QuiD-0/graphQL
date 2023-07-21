package com.quid.recipe.menu.gateway.api.request

import com.quid.recipe.menu.domain.Menu

class CreateMenuRequest(
    val name: String,
    val ingredientCodes: List<String> ,
    val price: Int
) {
    fun toMenu(): Menu =
        Menu(
            name = name,
            ingredientCodes = ingredientCodes,
            price = price
        )
}