package com.quid.recipe.menu.gateway.repository

import com.quid.recipe.ingredient.gateway.repository.IngredientRepository
import com.quid.recipe.menu.domain.Menu
import com.quid.recipe.menu.gateway.api.request.CreateMenuRequest
import com.quid.recipe.menu.gateway.repository.document.createMenuDocument
import com.quid.recipe.menu.gateway.repository.mongo.MongoMenuRepository
import org.springframework.stereotype.Repository

interface MenuRepository {
    fun save(request: CreateMenuRequest): Menu
    fun findAll(): List<Menu>

    @Repository
    class MenuRepositoryImpl(
        private val mongoMenuRepository: MongoMenuRepository,
        private val ingredientRepository: IngredientRepository,
    ) : MenuRepository {
        override fun save(request: CreateMenuRequest): Menu = ingredientRepository.findByCodes(request.ingredientCodes)
            .let { mongoMenuRepository.save(createMenuDocument(request, it)) }
            .toMenu()

        override fun findAll(): List<Menu> = mongoMenuRepository.findAll().map { it.toMenu() }
    }
}