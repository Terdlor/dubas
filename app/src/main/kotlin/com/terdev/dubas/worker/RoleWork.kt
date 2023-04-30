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
import javax.transaction.Transactional

@Component("roleWork")
class RoleWork : CommandWork() {

    override var command = "role"
    override var commandDesc = "Сохранение пользователя"

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss")

    @Autowired
    lateinit var roleRuleService: RoleRuleService

    @Autowired
    lateinit var userService: UserService

    @Transactional
    override fun commandWork(msg: Message) {
        val user = userService.getUser(msg.from)

        val strBuild = StringBuilder()

        strBuild.appendLine("user - " + user.userName)

        roleRuleService.getRule(RuleKeys.GET_BRENDS)
        roleRuleService.getRole(Roles.ADMIN)
        roleRuleService.addRuleInRole(Roles.ADMIN, RuleKeys.GET_BRENDS)
        val check = roleRuleService.checkRuleInRole(Roles.ADMIN, RuleKeys.GET_BRENDS)

        strBuild.appendLine("право - " + check)

        rsSH.sendSimpleNotification(msg.chatId, strBuild.toString())
    }
}