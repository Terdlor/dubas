package com.terdev.dubas.rolerule

import com.terdev.rolrul.common.RoleInterface

enum class Roles : RoleInterface {

    ADMIN,
    USER,
    UNKNOWN;

    override fun getName() = name

    companion object {
        fun valueOf(value: String?): Roles {
            return values().find { it.name == value } ?: UNKNOWN
        }
    }

}