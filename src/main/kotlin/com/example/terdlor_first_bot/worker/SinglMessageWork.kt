package com.example.terdlor_first_bot.worker

import com.example.terdlor_first_bot.bd.DatabaseHelper
import com.example.terdlor_first_bot.utils.LogHelper
import com.example.terdlor_first_bot.utils.SinglResponseHelper
import com.example.terdlor_first_bot.utils.Печататель
import com.example.terdlor_first_bot.utils.println
import org.telegram.telegrambots.bots.TelegramLongPollingBot

class SinglMessageWork(tgbParam : TelegramLongPollingBot) : SystemMessageWork(tgbParam) {

    fun work(msg : com.example.terdlor_first_bot.bd.model.Message) : Boolean {
        try {
            if (workSpam(msg)) {
                return true
            }

            val strBuild = StringBuilder()
            strBuild.appendLine(Печататель().дайMessage(msg))
            strBuild.appendLine(Печататель().дайВсеUser())
            strBuild.appendLine(Печататель().дайВсеChat())

            println(strBuild.toString())

            SinglResponseHelper(tgb).sendSimpleNotification(msg.chat, strBuild.toString(), msg.messageId)

            LogHelper().saveLog(strBuild.toString(), "Singl-" + DatabaseHelper.getUserDao().findById(msg.from)?.userName!!)

            msg.rs = strBuild.toString()
            msg.rs_chat_id = msg.chat.toString()
            DatabaseHelper.getMessageDao().update(msg)

            return true
        } catch (ex : Exception) {
            val str =Печататель().дайException(ex)
            println(str)
            LogHelper().saveLog(str, "ОШИБКА-Singl-" + DatabaseHelper.getUserDao().findById(msg.from)?.userName!!)
            SinglResponseHelper(tgb).sendSimpleNotification(msg.chat, str, msg.messageId)
            return false
        }
    }
}