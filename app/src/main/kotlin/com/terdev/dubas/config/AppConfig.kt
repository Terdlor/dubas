package com.terdev.dubas.config

import com.terdev.dubas.common.CommandWork
import com.terdev.dubas.common.DocumentWork
import com.terdev.dubas.utils.GroupResponseHelper
import com.terdev.dubas.utils.LogHelper
import com.terdev.dubas.utils.RequestHelper
import com.terdev.dubas.utils.SinglResponseHelper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.telegram.telegrambots.bots.TelegramLongPollingBot

@Configuration
class AppConfig {

    @Bean
    fun servletWebServerFactory(): ServletWebServerFactory? {
        return TomcatServletWebServerFactory()
    }

    @Bean
    fun getSinglResponseHelperBean(@Autowired tgbParam: TelegramLongPollingBot): SinglResponseHelper {
        return SinglResponseHelper(tgbParam)
    }

    @Bean
    fun getGroupResponseHelperBean(@Autowired tgbParam: TelegramLongPollingBot): GroupResponseHelper {
        return GroupResponseHelper(tgbParam)
    }

    @Bean
    fun getRequestHelperBean(@Autowired tgbParam: TelegramLongPollingBot): RequestHelper {
        return RequestHelper(tgbParam)
    }

    @Bean
    fun getLogHelper(): LogHelper {
        return LogHelper()
    }

    @Bean("commandWorkers")
    fun getCommandWorkers(@Autowired commandWorkers: List<CommandWork>) = commandWorkers

    @Bean("documentWorkers")
    fun getDocumentWorkers(@Autowired documentWork: List<DocumentWork>) = documentWork
}