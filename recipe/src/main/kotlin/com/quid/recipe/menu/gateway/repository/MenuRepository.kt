package com.quid.recipe.menu.gateway.repository

import com.quid.recipe.menu.domain.Menu
import com.quid.recipe.menu.gateway.repository.document.toDocument
import com.quid.recipe.menu.gateway.repository.mongo.MongoMenuRepository
import org.springframework.stereotype.Repository

interface MenuRepository {
    fun save(menu: Menu): Menu

    @Repository
    class MenuRepositoryImpl(
        private val mongoMenuRepository: MongoMenuRepository
    ) : MenuRepository {
        override fun save(menu: Menu): Menu = mongoMenuRepository.save(toDocument(menu)).toMenu()
    }
}