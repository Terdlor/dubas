package com.terdev.dubas.common

import com.terdev.dubas.BotApp
import org.telegram.telegrambots.meta.api.objects.Message
import org.telegram.telegrambots.meta.api.objects.MessageEntity


abstract class CommandWork : Work() {

    abstract fun commandWork(msgBd: com.terdev.dubas.bd.chat.model.Message)
    abstract fun commandWork(msg: Message)

    override fun checkWork(msg: Message, msgBd: com.terdev.dubas.bd.chat.model.Message): Boolean {
        if (msg.entities == null) return false
        val entity: MessageEntity? =
            msg.entities.stream().filter { en ->
                en.type == "bot_command" &&
                    (en.text.equals("/$command") || en.text.equals("/$command@" + BotApp.foo))
            }.findAny().orElse(null)
        if (entity != null) {
            commandWork(msgBd)
            commandWork(msg)
            return true
        }
        return false
    }
}