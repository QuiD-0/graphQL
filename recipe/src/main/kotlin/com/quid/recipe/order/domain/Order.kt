package com.quid.recipe.order.domain

import com.quid.recipe.menu.domain.Menu
import com.quid.recipe.order.domain.OrderStatus.ORDERED
import org.bson.types.ObjectId
import java.time.LocalDateTime

data class Order(
    val id: String = ObjectId.get().toHexString(),
    val orderedMenu: Map<Menu,Int>,
    val tableNumber: Int,
    val orderTime: LocalDateTime = LocalDateTime.now(),
    val orderStatus: OrderStatus = ORDERED,
) {
    init {
        require(orderedMenu.isNotEmpty()) { "orderedMenu is must not null" }
    }
    fun getTotalPrice(): Int {
        return orderedMenu.map { it.key.price * it.value }.sum()
    }
}

fun createOrder(orderedMenu: Map<Menu,Int>, tableNumber: Int) = Order(
    orderedMenu = orderedMenu,
    tableNumber = tableNumber
)