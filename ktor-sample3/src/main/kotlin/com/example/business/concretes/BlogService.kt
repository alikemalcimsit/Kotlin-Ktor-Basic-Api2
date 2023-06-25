package com.example.business.concretes

import com.example.business.abstracts.IBlogService
import com.example.dataaccess.abstracts.IBlogDao
import com.example.entities.BlogModel

class BlogService(private val iBlogDao: IBlogDao) : IBlogService {
    override fun getAll(): List<BlogModel> {
        return iBlogDao.getAll()
    }

    override fun create(blogModel: BlogModel) {
        iBlogDao.create(blogModel)
    }

    override fun delete(id: Int) {
        iBlogDao.delete(id)
    }

}