package com.quid.recipe.menu.gateway.api.request

class CreateMenuRequest(
    val name: String,
    val ingredientCodes: List<String> ,
    val price: Int
)