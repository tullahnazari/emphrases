package com.tullahnazari.emphrases.Model

import java.security.*

data class User(val displayName: String) : Principal, io.ktor.auth.Principal {
    override fun getName(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}