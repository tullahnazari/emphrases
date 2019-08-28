package com.tullahnazari.emphrases.Routes

import com.tullahnazari.emphrases.Repository.*
import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.locations.*
import io.ktor.response.*
import io.ktor.routing.*

const val SIGNUP = "/signup"

@Location(SIGNUP)
data class Signup(
    val userID: String = "",
    val displayName: String = "",
    val email: String = "",
    val error: String = "")

fun Route.signup(db: Repository, hashFunction: (String) -> String) {
    get<Signup> {
        call.respond(FreeMarkerContent("signup.ftl", null))
    }
}


