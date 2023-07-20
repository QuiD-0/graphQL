package com.quid.recipe.order.domain

import com.quid.recipe.menu.domain.Menu
import org.bson.types.ObjectId
import java.time.LocalDateTime

class Order(
    val id: String = ObjectId.get().toHexString(),
    val tableNumber: Int,
    val menu: List<Map<Menu,Int>>,
    val totalPrice: Int,
    val orderTime: LocalDateTime = LocalDateTime.now()
) {
}