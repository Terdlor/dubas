package com.terdev.dubas.worker

import com.terdev.context.ContextData
import com.terdev.context.ContextService
import com.terdev.dubas.common.CommandWork
import com.terdev.dubas.jpa.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Message
import java.text.SimpleDateFormat

@Component("context1")
class Context1Work : CommandWork() {

    override var command = "context1"
    override var commandDesc = "Сохранение пользователя"

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss")

    @Autowired
    lateinit var contextService: ContextService

    @Autowired
    lateinit var userService: UserService

    override fun commandWork(msg: Message) {
        val user = userService.getUser(msg.from)
        val userId = user.id ?: -1

        val strBuild = StringBuilder()

        strBuild.appendLine("user - " + user.userName)

        contextService.initData(ContextData(userId, user.role))

        strBuild.appendLine("из контекста - " + contextService.getData(userId))

        rsSH.sendSimpleNotification(msg.chatId, strBuild.toString())
    }
}