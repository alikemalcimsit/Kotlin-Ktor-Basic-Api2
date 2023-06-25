package com.example.dataaccess.abstracts

import com.example.entities.BlogModel

interface IBlogDao {
    fun getAll(): List<BlogModel>
    fun create(blogModel: BlogModel)
    fun delete(id: Int)

}

