package com.terdev.context

import org.springframework.stereotype.Component

@Component
class ContextService {

    private val contextMap: HashMap<Long, ContextData> = HashMap()

    fun cleanData(userId: Long) {
        contextMap.remove(userId)
    }

    fun initData(data: ContextData) {
        contextMap.set(data.userId, data)
    }

    fun getData(userId: Long): ContextData {
        return contextMap.get(userId) ?: throw ContextInitializationException("Контекста пользователя с ид = $userId не найдено")
    }

}