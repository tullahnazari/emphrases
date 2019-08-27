package com.tullahnazari.emphrases.Routes

import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.response.*
import io.ktor.locations.Location
import io.ktor.routing.*
import io.ktor.locations.get


const val HOME = "/"

@Location(HOME)
class Home

fun Route.home() {
    get<Home> {
        call.respond(FreeMarkerContent("home.ftl", null))
    }

}