package com.quid.recipe.ingredient.gateway.repository.mongo

import com.quid.recipe.ingredient.gateway.repository.document.IngredientDocument
import org.bson.types.ObjectId
import org.springframework.data.repository.CrudRepository

interface MongoIngredientRepository: CrudRepository<IngredientDocument, ObjectId> {
    fun findByCode(code: String): IngredientDocument?
    fun findByCodeIn(ingredients: List<String>): List<IngredientDocument>
}