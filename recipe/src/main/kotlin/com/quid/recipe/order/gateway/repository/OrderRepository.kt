package com.quid.recipe.order.gateway.repository

import com.quid.recipe.order.domain.Order
import com.quid.recipe.order.gateway.repository.document.toOrderDocument
import com.quid.recipe.order.gateway.repository.mongo.MongoOrderRepository
import org.springframework.stereotype.Repository

interface OrderRepository {
    fun save(order: Order): Order

    @Repository
    class OrderRepositoryImpl(
        private val mongoOrderRepository: MongoOrderRepository
    ) : OrderRepository {
        override fun save(order: Order): Order = mongoOrderRepository.save(toOrderDocument(order)).toOrder()
    }
}