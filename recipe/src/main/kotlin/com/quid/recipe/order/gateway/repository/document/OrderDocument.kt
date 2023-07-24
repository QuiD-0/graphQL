package com.quid.recipe.order.gateway.repository.document

import com.quid.recipe.menu.domain.Menu
import com.quid.recipe.order.domain.Order
import com.quid.recipe.order.domain.OrderStatus
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
class OrderDocument(
    @Id
    val id: ObjectId,
    val orderedMenu: Map<Menu,Int>,
    val tableNumber: Int,
    val orderTime: LocalDateTime,
    val orderStatus: OrderStatus,
) {
    fun toOrder() = Order(
        id = id.toHexString(),
        orderedMenu = orderedMenu,
        tableNumber = tableNumber,
        orderTime = orderTime,
        orderStatus = orderStatus
    )
}

fun toOrderDocument(order: Order) = OrderDocument(
    id = ObjectId(order.id),
    orderedMenu = order.orderedMenu,
    tableNumber = order.tableNumber,
    orderTime = order.orderTime,
    orderStatus = order.orderStatus
)