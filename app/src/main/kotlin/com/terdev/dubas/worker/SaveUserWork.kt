package com.terdev.dubas.worker

import com.terdev.dubas.common.CommandWork
import com.terdev.dubas.jpa.dao.BrandRepository
import com.terdev.dubas.jpa.entity.User
import com.terdev.dubas.jpa.dao.UserRepository
import com.terdev.dubas.jpa.entity.Brand
import com.terdev.dubas.jpa.entity.Line
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Message
import java.text.SimpleDateFormat
import java.util.Arrays.asList

@Component("saveUserWork")
class SaveUserWork : CommandWork() {

    override var command = "saveMy"
    override var commandDesc = "Сохранение пользователя"

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss")

    @Autowired
    lateinit var userrRepository: UserRepository

    @Autowired
    lateinit var brandRepository: BrandRepository

    override fun commandWork(msg: Message) {
        val user = User()
        user.id = msg.from.id
        user.firstName = msg.from.firstName
        user.isBot = msg.from.isBot
        user.lastName = msg.from.lastName
        user.userName = msg.from.userName
        user.languageCode = msg.from.languageCode

        userrRepository.save(user)

        val brand = Brand()
        brand.name = "brand"

        val line = Line()
        line.name = "line"
        line.brand = brand

        brand.lines = asList(line)

        brandRepository.save(brand)

        val list = brandRepository.findAll()
        val strBuild = StringBuilder()

        list.forEach {
            strBuild.appendLine("brand - " + it.name)
            it.lines?.forEach {
                strBuild.appendLine("line - " + it.name)
            }
            strBuild.appendLine("\n")
        }

        rsSH.sendSimpleNotification(msg.chatId, strBuild.toString())
    }
}