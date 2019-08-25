package com.tullahnazari.emphrases.Routes

import com.tullahnazari.emphrases.Repository.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

const val PHRASES = "/phrases"

fun Route.phrases(db: Repository) {
    get(PHRASES) {
        val phrases = db.phrases()
        call.respond(phrases.toArray())
    }
}