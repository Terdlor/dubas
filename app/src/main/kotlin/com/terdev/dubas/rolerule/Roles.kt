package com.terdev.dubas.rolerule

import com.terdev.rolrul.common.RoleInterface

enum class Roles : RoleInterface {

    ADMIN,
    USER;

    override fun getName() = name
}