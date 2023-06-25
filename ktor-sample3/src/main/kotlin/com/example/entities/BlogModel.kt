package com.example.entities


import kotlinx.serialization.Serializable
import org.jetbrains.exposed.dao.id.IntIdTable
@Serializable
data class BlogModel(val id: Int, val title: String, val content: String, val time: Int)

object Blogs : IntIdTable() {
    val title = varchar("title", 30)
    val content = text("content")
    val time = integer("time")
}