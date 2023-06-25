package com.example.apicontroller

import com.example.business.abstracts.IBlogService
import com.example.entities.BlogModel

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

class BlogController(private val iBlogService: IBlogService) {

    fun Route.getAll() {
        get("/blog/getall") {

            call.respond(HttpStatusCode.OK, iBlogService.getAll())

        }

    }

    fun Route.create() {

        get("/blog/create") {

            val blog = call.receive<BlogModel>()
            iBlogService.create(blog)

        }
    }


    fun Route.delete() {
        delete("/blog/delete{id}") {
            val id = call.parameters["id"]
            iBlogService.delete(id!!.toInt())

        }
    }


}