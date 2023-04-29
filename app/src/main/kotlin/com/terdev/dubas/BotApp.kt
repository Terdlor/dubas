package com.terdev.dubas

import com.terdev.dubas.common.CommandWork
import com.terdev.dubas.worker.HelpWork
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.core.env.Environment
import org.springframework.stereotype.Service
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.objects.Update

@Service
class BotApp : TelegramLongPollingBot() {

    @Autowired
    private lateinit var context: ApplicationContext

    @Autowired
    private lateinit var env: Environment

    override fun getBotUsername(): String = env.getProperty("telegram.botName")!!

    override fun getBotToken(): String = env.getProperty("telegram.token")!!

    override fun onUpdateReceived(update: Update) {
        if (context.getBean("helpWork", HelpWork::class.java).work(update.message)) return

        val commandWorkers = context.getBean("commandWorkers")
        if (commandWorkers is List<*>) {
            for (commandWork in commandWorkers) {
                if (commandWork is CommandWork && commandWork.work(update.message)) return
            }
        }
    }

}