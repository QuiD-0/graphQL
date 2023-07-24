package com.quid.recipe.order.gateway.repository.mongo

import com.quid.recipe.order.gateway.repository.document.OrderDocument
import org.bson.types.ObjectId
import org.springframework.data.repository.CrudRepository

interface MongoOrderRepository : CrudRepository<OrderDocument, ObjectId> {
}