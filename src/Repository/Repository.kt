package com.tullahnazari.emphrases.Repository

import com.tullahnazari.emphrases.Model.*

interface Repository {
    suspend fun add(userId: String, emojiValue: String, phraseValue: String)
    suspend fun phrase(id: Int): EmojiPhrase
    suspend fun phrase(id: String): EmojiPhrase
    suspend fun phrases(): List<EmojiPhrase>
    suspend fun remove(id: Int): Boolean
    suspend fun remove(id: String): Boolean
    suspend fun clear()
    suspend fun user(userId: String, hash: String? = null): User?
    suspend fun userByEmail(email: String): User?
    suspend fun createUser(user: User)
}