package com.quid.recipe.menu.gateway.repository.document

import com.quid.recipe.ingredient.domain.Ingredient
import com.quid.recipe.ingredient.gateway.repository.document.IngredientDocument
import com.quid.recipe.ingredient.gateway.repository.document.toIngredientDocument
import com.quid.recipe.menu.domain.Menu
import com.quid.recipe.menu.gateway.api.request.CreateMenuRequest
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "menu")
class MenuDocument(
    @Id
    val id: ObjectId,
    val name: String,
    @DBRef
    val ingredients: List<IngredientDocument>,
    val price: Int
) {
    fun toMenu() = Menu(
        id = id.toHexString(),
        name = name,
        ingredients = ingredients.map { it.toIngredient() },
        price = price
    )
}
fun createMenuDocument(request: CreateMenuRequest, ingredient: List<Ingredient>) = MenuDocument(
    id = ObjectId.get(),
    name = request.name,
    ingredients = ingredient.map { toIngredientDocument(it) },
    price = request.price
)