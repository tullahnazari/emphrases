package com.tullahnazari.emphrases.Routes

import com.tullahnazari.emphrases.Repository.*
import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.locations.*
import io.ktor.response.*
import io.ktor.routing.*

const val SIGNIN = "/signin"

@Location(SIGNIN)
data class Signin(val userId: String = "", val error: String = "")

fun Route.signin(db: Repository, hasFunction: (String) -> String) {
    get<Signin> {
        call.respond(FreeMarkerContent("signin.ftl", null))
    }
}