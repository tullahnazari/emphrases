package com.tullahnazari.emphrases.Routes

import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.locations.*
import io.ktor.response.*
import io.ktor.routing.*
import java.awt.desktop.*

//make it const for reusability
const val ABOUT = "/about"

@Location(ABOUT)
class About

fun Route.about() {
    get<About> {
        call.respond(FreeMarkerContent("about.ftl", null))
    }

}