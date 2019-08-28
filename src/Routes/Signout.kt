package com.tullahnazari.emphrases.Routes

import com.tullahnazari.emphrases.*
import com.tullahnazari.emphrases.Repository.*
import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.locations.*
import io.ktor.response.*
import io.ktor.routing.*

const val SIGNOUT = "/signout"

@Location(SIGNOUT)
class Signout

fun Route.signout() {
    get<Signout> {
        call.redirect(Signin())
    }
}