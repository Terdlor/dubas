package com.terdev.dubas.content

import com.google.gson.GsonBuilder
import com.terdev.dubas.bd.DatabaseHelper
import com.terdev.dubas.common.CommandWork
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Message
import java.io.File
import java.nio.file.Paths
import java.text.SimpleDateFormat
import java.util.*


@Component("getBrandWork")
class GetBrandWork : CommandWork() {

    override var command = "sys_get_brands"
    override var commandDesc = "Получение брендов(content)"

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss")

    override fun commandWork(msgBd: com.terdev.dubas.bd.chat.model.Message) {

        val brandList = DatabaseHelper.getBrandDao().queryForAll()
        val gsonPretty = GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create()

        val fileName = "BRANDS-${dateFormat.format(Date())}.json"
        val wallpaperDirectory = File(Paths.get("").toAbsolutePath().toString() + "\\tmp\\")
        wallpaperDirectory.mkdirs()

        val file = File(wallpaperDirectory, fileName)
        file.writeText(gsonPretty.toJson(brandList))

        sendFile(msgBd.chat, file)
    }

    override fun commandWork(msg: Message) {

    }
}