package com.example.terdlor_first_bot.bd.model

import com.example.terdlor_first_bot.bd.DatabaseHelper
import com.j256.ormlite.dao.BaseDaoImpl
import com.j256.ormlite.support.ConnectionSource
import java.sql.SQLException


class MessageDaoImpl(connectionSource: ConnectionSource?) : BaseDaoImpl<Message, Long>(connectionSource, Message::class.java), MessageDao {

    @Throws(SQLException::class)
    override fun findById(id: Int): List<Message>?{
        return super.queryForEq("messageId", id)
    }

    override fun saveIfNotExist(messageTG: org.telegram.telegrambots.meta.api.objects.Message?) {
        if (messageTG != null)
            if  (findById(messageTG.messageId)?.isEmpty() == true) {
                val message = Message()
                message.messageId = messageTG.messageId

                val userDao = DatabaseHelper.getUserDao()
                userDao.saveIfNotExist(messageTG.from)
                message.from = messageTG.from.id

                message.date = messageTG.date

                val chatDao = DatabaseHelper.getChatDao()
                chatDao.saveIfNotExist(messageTG.chat)
                message.chat = messageTG.chat.id

                if (messageTG.forwardFrom != null) {
                    userDao.saveIfNotExist(messageTG.forwardFrom)
                    message.forwardFrom = messageTG.forwardFrom.id
                }

                if (messageTG.forwardFromChat != null) {
                    chatDao.saveIfNotExist(messageTG.forwardFromChat)
                    message.forwardFromChat = messageTG.forwardFromChat.id
                }

                message.forwardDate = messageTG.forwardDate
                message.text = messageTG.text
                create(message)
            }
    }
}