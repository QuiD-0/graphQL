package com.quid.recipe.menu.usecase

import com.quid.recipe.menu.domain.Menu
import com.quid.recipe.menu.gateway.api.request.CreateMenuRequest
import com.quid.recipe.menu.gateway.repository.MenuRepository
import org.springframework.stereotype.Service

interface CreateMenu {
    fun execute(request: CreateMenuRequest): Menu

    @Service
    class CreateMenuUseCase(
        private val menuRepository: MenuRepository,
    ) : CreateMenu {
        override fun execute(request: CreateMenuRequest): Menu =
            menuRepository.save(request.toMenu())
    }
}