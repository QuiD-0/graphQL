package com.quid.recipe.menu.gateway.api

import com.quid.recipe.menu.gateway.api.request.CreateMenuRequest
import com.quid.recipe.menu.usecase.CreateMenu
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.stereotype.Controller

@Controller
class MenuController(
    private val createMenu: CreateMenu,
) {

    @MutationMapping
    fun createMenu(@Argument request: CreateMenuRequest) = createMenu.execute(request)

}