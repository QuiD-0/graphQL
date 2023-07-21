package com.quid.recipe.menu.gateway.repository.mongo

import com.quid.recipe.menu.gateway.repository.document.MenuDocument
import org.bson.types.ObjectId
import org.springframework.data.repository.CrudRepository

interface MongoMenuRepository: CrudRepository<MenuDocument, ObjectId> {
}