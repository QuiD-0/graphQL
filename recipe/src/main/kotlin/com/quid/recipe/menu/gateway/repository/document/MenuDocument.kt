package com.quid.recipe.menu.gateway.repository.document

import com.quid.recipe.menu.domain.Menu
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "menu")
class MenuDocument(
    @Id
    val id: ObjectId,
    val name: String,
    val ingredientCodes: List<String> ,
    val price: Int
) {
    fun toMenu() = Menu(
        name = name,
        ingredientCodes = ingredientCodes,
        price = price
    )
}
fun toDocument(menu: Menu) = MenuDocument(
    id = ObjectId(menu.id),
    name = menu.name,
    ingredientCodes = menu.ingredientCodes,
    price = menu.price
)