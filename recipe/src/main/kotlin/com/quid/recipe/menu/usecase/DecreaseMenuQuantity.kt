package com.quid.recipe.menu.usecase

import com.quid.recipe.ingredient.usecase.DecreaseQuantity
import com.quid.recipe.menu.domain.Menu
import org.springframework.stereotype.Service

interface DecreaseMenuQuantity {
    fun decrease(menuList: Map<Menu, Int>)

    @Service
    class DecreaseMenuQuantityUseCase(
        private val decreaseQuantity: DecreaseQuantity
    ) : DecreaseMenuQuantity {
        override fun decrease(menuList: Map<Menu, Int>) =
            menuList
                .map { it.key.ingredients.map { ingredient -> ingredient to it.value } }
                .flatten()
                .groupBy { it.first }
                .map { it.key to it.value.sumOf { pair -> pair.second } }
                .forEach { decreaseQuantity.decrease(it.first.code, it.second) }
    }
}