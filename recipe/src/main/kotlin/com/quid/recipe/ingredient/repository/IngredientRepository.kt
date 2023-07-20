package com.quid.recipe.ingredient.repository

import com.quid.recipe.ingredient.domain.Ingredient
import com.quid.recipe.ingredient.repository.document.toDocument
import com.quid.recipe.ingredient.repository.mongo.MongoIngredientRepository
import org.springframework.stereotype.Repository

interface IngredientRepository {
    fun save(ingredient: Ingredient): Ingredient
    fun findAll(): List<Ingredient>
    fun findByCode(code: String): Ingredient
    fun existsByCode(code: String): Boolean

    @Repository
    class IngredientRepositoryImpl(
        private val mongoRepository: MongoIngredientRepository
    ) : IngredientRepository {

        override fun save(ingredient: Ingredient): Ingredient =
            toDocument(ingredient).let { mongoRepository.save(it) }.toIngredient()

        override fun findAll(): List<Ingredient> =
            mongoRepository.findAll().map { it.toIngredient() }

        override fun findByCode(code: String): Ingredient =
            mongoRepository.findByCode(code)?.toIngredient()
                ?: throw Exception("Ingredient not found")

        override fun existsByCode(code: String): Boolean =
            mongoRepository.findByCode(code)
                ?.let { it.quantity > 0 }
                ?: false
    }
}