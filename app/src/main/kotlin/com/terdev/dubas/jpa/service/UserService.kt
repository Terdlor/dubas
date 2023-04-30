package com.terdev.dubas.jpa.service

import com.terdev.dubas.jpa.dao.UserRepository
import com.terdev.dubas.jpa.entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    fun getUser(userTg : org.telegram.telegrambots.meta.api.objects.User) : User {
        return userRepository.findByUserName(userTg.userName) ?: with(User()){
            val user = User()
            user.id = userTg.id
            user.firstName = userTg.firstName
            user.isBot = userTg.isBot
            user.lastName = userTg.lastName
            user.userName = userTg.userName
            user.languageCode = userTg.languageCode

            userRepository.save(user)
        }
    }
}