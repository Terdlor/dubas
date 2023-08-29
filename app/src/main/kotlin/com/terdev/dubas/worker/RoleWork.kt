package com.terdev.dubas.worker

import com.terdev.dubas.common.CommandWork
import com.terdev.dubas.jpa.service.UserService
import com.terdev.dubas.rolerule.Roles
import com.terdev.dubas.rolerule.RuleKeys
import com.terdev.rolrul.service.RoleRuleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Message
import java.text.SimpleDateFormat

@Component("roleWork")
class RoleWork : CommandWork() {

    override var command = "role"
    override var commandDesc = "Сохранение пользователя"

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss")

    @Autowired
    lateinit var roleRuleService: RoleRuleService

    @Autowired
    lateinit var userService: UserService

    override fun commandWork(msg: Message) {
        val user = userService.getUser(msg.from)

        val strBuild = StringBuilder()

        strBuild.appendLine("user - " + user.userName)

        roleRuleService.addRuleInRole(Roles.ADMIN, RuleKeys.GET_BRENDS)
        roleRuleService.checkRuleInRole(Roles.valueOf(user.role), RuleKeys.GET_BRENDS)
        roleRuleService.deleteRuleInRole(Roles.ADMIN, RuleKeys.GET_BRENDS)

        roleRuleService.getRuleFromRole(Roles.valueOf(user.role)).forEach {
            strBuild.appendLine("право - " + it.getKey())
        }

        rsSH.sendSimpleNotification(msg.chatId, strBuild.toString())
    }
}