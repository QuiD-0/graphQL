package com.quid.recipe.ingredient.repository.document

import com.quid.recipe.ingredient.domain.Ingredient
import com.quid.recipe.ingredient.domain.UnitType
import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document("ingredient")
class IngredientEntity(
    val id: ObjectId,
    val name: String,
    val code: String,
    val quantity: Int,
    val unit: UnitType,
    val savePoint: String,
    val lastModifiedDate: LocalDateTime
) {
    fun toIngredient() = Ingredient(
        id = id.toHexString(),
        name = name,
        code = code,
        quantity = quantity,
        unit = unit,
        savePoint = savePoint,
        lastModifiedDate = lastModifiedDate
    )
}

fun toDocument(ingredient: Ingredient) = IngredientEntity(
    id = ObjectId(ingredient.id),
    name = ingredient.name,
    code = ingredient.code,
    quantity = ingredient.quantity,
    unit = ingredient.unit,
    savePoint = ingredient.savePoint,
    lastModifiedDate = ingredient.lastModifiedDate
)