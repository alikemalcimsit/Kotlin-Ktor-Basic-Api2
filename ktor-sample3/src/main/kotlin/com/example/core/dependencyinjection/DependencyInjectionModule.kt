package com.example.core.dependencyinjection

import org.koin.dsl.module


import org.jetbrains.exposed.sql.Database

import com.example.apicontroller.BlogController
import com.example.business.abstracts.IBlogService
import com.example.business.concretes.BlogService
import com.example.dataaccess.concretes.BlogDao
import com.example.entities.Blogs

val controllerModule= module{

    single<IBlogService> { BlogService(BlogDao(Blogs)) }
    single { BlogController(get()) }


}
