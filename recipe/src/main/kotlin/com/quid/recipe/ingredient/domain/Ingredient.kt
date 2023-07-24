package com.quid.recipe.ingredient.domain

import org.bson.types.ObjectId
import java.time.LocalDateTime

data class Ingredient(
    val id: String = ObjectId.get().toHexString(),
    val name:String,
    val code:String,
    val quantity: Int,
    val unit: UnitType,
    val savePoint: String,
    val lastModifiedDate: LocalDateTime = LocalDateTime.now()
){
    init {
        require(quantity >= 0) { "quantity is must not null" }
    }
}