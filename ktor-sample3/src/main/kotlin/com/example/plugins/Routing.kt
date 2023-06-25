package com.example.plugins

import com.example.apicontroller.BlogController
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }
}


fun Application.blogRouting(){
val blogController:BlogController by inject()
    routing {
blogController.apply {
    getAll()
    create()
    delete()
}
    }
}
