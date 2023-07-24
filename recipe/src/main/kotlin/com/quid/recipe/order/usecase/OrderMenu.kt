package com.quid.recipe.order.usecase

import com.quid.recipe.menu.gateway.repository.MenuRepository
import com.quid.recipe.menu.usecase.DecreaseMenuQuantity
import com.quid.recipe.menu.usecase.MakeFood
import com.quid.recipe.order.domain.Order
import com.quid.recipe.order.domain.createOrder
import org.springframework.stereotype.Service

interface OrderMenu {
    fun execute(menuList: Map<String, Int>, tableNumber: Int): Order

    @Service
    class OrderMenuImpl(
        private val makeFood: MakeFood,
        private val decreaseMenu: DecreaseMenuQuantity,
        private val orderRepository: OrderRepository
    ) : OrderMenu {
        override fun execute(menuList: Map<String, Int>, tableNumber: Int): Order =
            makeFood.execute(menuList)
                .also { decreaseMenu.decrease(it) }
                .let { createOrder(it, tableNumber) }
                .also { orderRepository.save(it) }
    }
}