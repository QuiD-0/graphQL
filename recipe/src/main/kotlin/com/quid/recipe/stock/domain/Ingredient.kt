package com.quid.recipe.stock.domain

import org.bson.types.ObjectId
import java.time.LocalDateTime

class Ingredient(
    val id: String = ObjectId.get().toHexString(),
    val name:String,
    val code:String,
    val quantity: Int,
    val unit: UnitType,
    val savePoint: String,
    val lastModifiedDate: LocalDateTime = LocalDateTime.now()
)