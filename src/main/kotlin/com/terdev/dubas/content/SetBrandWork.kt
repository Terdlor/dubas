package com.terdev.dubas.content

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.terdev.dubas.bd.DatabaseHelper
import com.terdev.dubas.bd.dubas.model.Brand
import com.terdev.dubas.common.DocumentWork
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Document
import java.util.*


@Component("setBrandWork")
class SetBrandWork : DocumentWork() {

    override var command = "sys_set_brands"
    override var commandDesc = "Запись брендов(content)"

    override fun commandWork(msgBd: com.terdev.dubas.bd.chat.model.Message, doc: Document) {

        DatabaseHelper.getBrandDao().removeAll { true }
        sendNotification(msgBd.chat, "ВСЕ УДАЛЕНО")

        val file = getFile(doc.fileId)

        val res = file.inputStream().bufferedReader().use { it.readText() }

        val arrayBrendType = object : TypeToken<Array<Brand>>() {}.type

        val brends: Array<Brand> = Gson().fromJson(res, arrayBrendType)
        brends.forEach { it.insert_date = Date(); DatabaseHelper.getBrandDao().create(it) }

        sendNotification(msgBd.chat, "чот загружено")


    }
}