package com.quid.recipe.ingredient.gateway.repository.mongo

import com.quid.recipe.ingredient.gateway.repository.document.IngredientEntity
import org.bson.types.ObjectId
import org.springframework.data.repository.CrudRepository

interface MongoIngredientRepository: CrudRepository<IngredientEntity, ObjectId> {
    fun findByCode(code: String): IngredientEntity?
    fun findByCodeIn(ingredients: List<String>): List<IngredientEntity>
}