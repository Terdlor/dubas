package com.terdev.dubas

import com.terdev.dubas.common.CommandWork
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.objects.Update
import java.util.*

@Service
class BotApp : TelegramLongPollingBot() {

    @Autowired
    private lateinit var context: ApplicationContext

    @Value("\${telegram.botName}")
    private lateinit var botName: String

    @Value("\${telegram.token}")
    private lateinit var token: String

    companion object {
        var foo: String = "botName"
    }

    override fun getBotUsername(): String = botName

    override fun getBotToken(): String = token

    override fun onUpdateReceived(update: Update) {
        val commandWorkers = context.getBean("commandWorkers")
        if (commandWorkers is List<*>) {
            for (commandWork in commandWorkers) {
                if (commandWork is CommandWork && commandWork.work(update.message)) return
            }
        }
    }

}