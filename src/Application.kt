package com.tullahnazari.emphrases

import com.ryanharter.ktor.moshi.*
import com.tullahnazari.emphrases.Repository.*
import com.tullahnazari.emphrases.Routes.*
import com.tullahnazari.emphrases.api.*
import freemarker.cache.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.freemarker.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.netty.handler.codec.*
import io.netty.handler.codec.DefaultHeaders

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    install(io.ktor.features.DefaultHeaders)

    install(StatusPages){
        exception<Throwable> {
            e -> call.respondText(e.localizedMessage, ContentType.Text.Plain,
            HttpStatusCode.InternalServerError)
        }
    }

    install(ContentNegotiation) {
        moshi()
    }

    val  db = inMemoryRepo()

    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "Templates")

    }


    routing {

        home()
        about()
        phrases(db)
        phrase(db)
    }
}

const val API_VERSION= "/api/v1"



