package com.tullahnazari.emphrases

import com.ryanharter.ktor.moshi.*
import com.sun.net.httpserver.*
import com.sun.tools.javac.file.*
import com.tullahnazari.emphrases.Model.*
import com.tullahnazari.emphrases.Repository.*
import com.tullahnazari.emphrases.Routes.*
import com.tullahnazari.emphrases.api.*
import freemarker.cache.*
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.features.*
import io.ktor.freemarker.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.locations.*
import io.ktor.locations.Locations
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


    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "Templates")

    }



    install(Locations)

    val hashFunction = {s: String -> hash(s)}

    DatabaseFactory.init()

    val db = EmojiPhrasesRepository()




    routing {
        static("/static") {
            this.resources("images")
        }

        home()
        about()
        phrases(db)
        signin(db, hashFunction)
        signout()
        signup(db, hashFunction)
        phrase(db)
    }
}

const val API_VERSION= "/api/v1"

suspend fun ApplicationCall.redirect(location: Any) {
    respondRedirect(application.locations.href(location))
}



