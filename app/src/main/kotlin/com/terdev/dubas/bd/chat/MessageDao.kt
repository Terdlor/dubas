package com.terdev.dubas.bd.chat

import com.j256.ormlite.dao.Dao
import com.terdev.dubas.bd.chat.model.Message
import java.sql.SQLException

interface MessageDao : Dao<Message, Long> {

    @Throws(SQLException::class)
    fun findById(id: Int): Message?

    fun saveIfNotExist(messageTG: org.telegram.telegrambots.meta.api.objects.Message?)

    fun save(messageTG: org.telegram.telegrambots.meta.api.objects.Message): Message

    fun getLastSpamCount(keyWord: Set<String>, delay: Int): Map<String, Int>
}