package com.terdev.dubas.worker

import com.terdev.dubas.common.CommandWork
import com.terdev.dubas.jpa.entity.User
import com.terdev.dubas.jpa.dao.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Message
import java.text.SimpleDateFormat

@Component("saveUserWork")
class SaveUserWork : CommandWork() {

    override var command = "saveMy"
    override var commandDesc = "Сохранение пользователя"

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss")

    @Autowired
    lateinit var rep: UserRepository

    override fun commandWork(msg: Message) {
        val user = User()
        user.id = msg.from.id
        user.firstName = msg.from.firstName
        user.isBot = msg.from.isBot
        user.lastName = msg.from.lastName
        user.userName = msg.from.userName
        user.languageCode = msg.from.languageCode

        rep.save(user)
    }
}