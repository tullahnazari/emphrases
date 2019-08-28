package com.tullahnazari.emphrases

import io.ktor.util.*
import javax.crypto.*
import javax.crypto.spec.*

val hashKey = hex(System.getenv("SECRET_KEY"))

val hmacKey = SecretKeySpec(hashKey, "HmacSHA1")


fun hash(password: String): String {
    val hmac = Mac.getInstance("HmacSHA1")
    hmac.init(hmacKey)
    return hex(hmac.doFinal(password.toByteArray(Charsets.UTF_8)))
}

private val userIdPattern = "[a-zA-Z0-9_\\.]+".toRegex()
internal fun userNameValid(userId: String) = userId.matches(userIdPattern)