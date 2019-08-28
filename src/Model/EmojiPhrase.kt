package com.tullahnazari.emphrases.Model

import org.jetbrains.exposed.dao.*
import org.jetbrains.exposed.sql.*
import java.io.Serializable

data class EmojiPhrase
    (var id: Int,
    val emoji: String,
     val phrase: String) : Serializable

object EmojiPhrases : IntIdTable() {
    val emoji: Column<String> = varchar("emoji", 255)
    val phrase: Column<String> = varchar("phrase", 255)
}