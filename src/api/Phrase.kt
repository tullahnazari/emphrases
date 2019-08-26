package com.tullahnazari.emphrases.api

import com.tullahnazari.emphrases.*
import com.tullahnazari.emphrases.Model.*
import com.tullahnazari.emphrases.Repository.*
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

const val PHRASE_ENDPOINT = "/phrase"

fun Route.phrase(db: Repository) {

    authenticate("auth") {
        post(com.tullahnazari.emphrases.api.PHRASE_ENDPOINT) {
            val request = call.receive<Request>()
            val phrase = db.add(EmojiPhrase(request.emoji, request.phrase))
            call.respond(phrase)
        }
    }
}