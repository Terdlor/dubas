package com.terdev.context

import lombok.Data

@Data
class ContextData(
    val userId: Long,
    val role: String? = "UNKNOWN"
) {
    override fun toString(): String {
        return "ContextData {" +
            "userId = $userId, "+
            "role = $role"+
            "}"
    }
}