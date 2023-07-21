package com.quid.recipe.menu.usecase

import com.quid.recipe.menu.domain.Menu
import com.quid.recipe.menu.gateway.repository.MenuRepository
import org.springframework.stereotype.Service

interface FindMenu {
    fun all(): List<Menu>

    @Service
    class FindMenuImpl(
        private val menuRepository: MenuRepository
    ) : FindMenu {
        override fun all(): List<Menu> = menuRepository.findAll()
    }
}