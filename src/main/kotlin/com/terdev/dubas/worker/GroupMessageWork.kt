package com.terdev.dubas.worker

import com.terdev.dubas.bd.DatabaseHelper
import com.terdev.dubas.bd.chat.model.Message
import com.terdev.dubas.utils.GroupResponseHelper
import com.terdev.dubas.utils.LogHelper
import com.terdev.dubas.utils.Печататель
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component("groupMessageWorkBean")
class GroupMessageWork {

    @Autowired
    private lateinit var rshG: GroupResponseHelper

    @Autowired
    private lateinit var log: LogHelper

    fun work(msg: Message): Boolean {
        try {
            return true
        } catch (ex: Exception) {
            val str = Печататель().дайException(ex)
            println(str)
            log.saveLog(str, "ОШИБКА-Group-" + DatabaseHelper.getUserDao().findById(msg.from)?.userName!!)
            rshG.sendSimpleNotification(msg.chat, str, msg.messageId)
            return false
        }
    }
}