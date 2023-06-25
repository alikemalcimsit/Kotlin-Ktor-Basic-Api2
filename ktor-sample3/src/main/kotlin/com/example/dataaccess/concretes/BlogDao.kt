package com.example.dataaccess.concretes

import com.example.core.connectdb.ConnectDb
import com.example.dataaccess.abstracts.IBlogDao
import com.example.entities.BlogModel
import com.example.entities.Blogs
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction


class BlogDao(private val table: Blogs) : IBlogDao, ConnectDb<Blogs>(table) {
    override fun getAll(): List<BlogModel> {
        return transaction {
            table.selectAll().map { resultRow ->
                BlogModel(
                    id = resultRow[Blogs.id].value,
                    title = resultRow[Blogs.title],
                    content = resultRow[Blogs.content],
                    time = resultRow[Blogs.time]
                )
            }
        }

    }

    override fun create(blogModel: BlogModel) {

        transaction {
            table.insert {
                it[title] = blogModel.title
                it[content] = blogModel.content
                it[time] = blogModel.time
            }
        }
    }

    override fun delete(id: Int) {

        transaction {
            table.deleteWhere { Blogs.id.eq(id) }
        }
    }


}