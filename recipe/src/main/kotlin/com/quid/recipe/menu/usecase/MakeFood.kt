package com.quid.recipe.menu.usecase

import com.quid.recipe.menu.domain.Menu
import com.quid.recipe.menu.gateway.repository.MenuRepository
import org.springframework.stereotype.Service

interface MakeFood {
    fun execute(menuList: Map<String, Int>): Map<Menu,Int>

    @Service
    class MakeFoodUseCase(
        private val menuRepository: MenuRepository
    ) : MakeFood {
        override fun execute(menuList: Map<String, Int>): Map<Menu, Int> {
            return menuList.map { menuRepository.findByName(it.key) to it.value }.toMap()
        }
    }
}