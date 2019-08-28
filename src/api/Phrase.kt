package com.tullahnazari.emphrases.api

import com.tullahnazari.emphrases.*
import com.tullahnazari.emphrases.Model.*
import com.tullahnazari.emphrases.Repository.*
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.routing.post

const val PHRASE_ENDPOINT = "$API_VERSION/phrase"

@Location(PHRASE_ENDPOINT)
class Phrase

fun Route.phrase(db: Repository) {

        post<Phrase> {
            val request = call.receive<Request>()
            val phrase = db.add("", request.emoji, request.phrase)
            call.respond(phrase)
        }

}