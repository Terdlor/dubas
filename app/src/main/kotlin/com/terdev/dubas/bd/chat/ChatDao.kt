package com.terdev.dubas.bd.chat

import com.j256.ormlite.dao.Dao
import com.terdev.dubas.bd.chat.model.Chat
import java.sql.SQLException

interface ChatDao : Dao<Chat, Long> {

    @Throws(SQLException::class)
    fun findById(id: Long): Chat?

    fun saveIfNotExist(chatTG: org.telegram.telegrambots.meta.api.objects.Chat?)

    fun getActive(): List<Chat>
}