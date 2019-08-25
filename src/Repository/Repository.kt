package com.tullahnazari.emphrases.Repository

import com.tullahnazari.emphrases.Model.*

interface Repository {
    suspend fun add(phrase: EmojiPhrase): EmojiPhrase
    suspend fun phrase(id: Int): EmojiPhrase
    suspend fun phrase(id: String): EmojiPhrase
    suspend fun phrases(): ArrayList<EmojiPhrase>
    suspend fun remove(phrase: EmojiPhrase)
    suspend fun remove(id: Int): Boolean
    suspend fun remove(id: String): Boolean
    suspend fun clear()
}