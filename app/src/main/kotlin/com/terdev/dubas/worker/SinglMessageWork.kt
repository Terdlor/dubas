package com.terdev.dubas.worker

import com.terdev.dubas.bd.DatabaseHelper
import com.terdev.dubas.bd.chat.model.Message
import com.terdev.dubas.utils.LogHelper
import com.terdev.dubas.utils.SinglResponseHelper
import com.terdev.dubas.utils.println
import com.terdev.dubas.utils.Печататель
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component("singlMessageWorkBean")
class SinglMessageWork {

    @Autowired
    private lateinit var rshS: SinglResponseHelper

    @Autowired
    private lateinit var log: LogHelper

    fun work(msg: Message): Boolean {
        try {
            val strBuild = StringBuilder()
            strBuild.appendLine(Печататель().дайMessage(msg))
            strBuild.appendLine(Печататель().дайВсеUser())
            strBuild.appendLine(Печататель().дайВсеChat())

            println(strBuild.toString())

            rshS.sendSimpleNotification(msg.chat, strBuild.toString(), msg.messageId)

            log.saveLog(strBuild.toString(), "Singl-" + DatabaseHelper.getUserDao().findById(msg.from)?.userName!!)

            msg.rs = strBuild.toString()
            msg.rs_chat_id = msg.chat.toString()
            DatabaseHelper.getMessageDao().update(msg)

            return true
        } catch (ex: Exception) {
            val str = Печататель().дайException(ex)
            println(str)
            log.saveLog(str, "ОШИБКА-Singl-" + DatabaseHelper.getUserDao().findById(msg.from)?.userName!!)
            rshS.sendSimpleNotification(msg.chat, str, msg.messageId)
            return false
        }
    }
}