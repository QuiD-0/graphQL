package com.quid.recipe.ingredient.repository.mongo

import com.quid.recipe.ingredient.repository.document.IngredientEntity
import org.bson.types.ObjectId
import org.springframework.data.repository.CrudRepository

interface MongoIngredientRepository: CrudRepository<IngredientEntity, ObjectId> {
    fun findByCode(code: String): IngredientEntity?
}