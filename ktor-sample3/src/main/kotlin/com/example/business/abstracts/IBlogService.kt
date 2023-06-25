package com.example.business.abstracts

import com.example.entities.BlogModel

interface IBlogService {

    fun getAll(): List<BlogModel>
    fun create(blogModel: BlogModel)
    fun delete(id: Int)
}