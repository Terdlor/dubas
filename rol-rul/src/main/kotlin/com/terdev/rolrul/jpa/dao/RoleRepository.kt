package com.terdev.rolrul.jpa.dao

import com.terdev.rolrul.jpa.entity.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository : JpaRepository<Role, Long> {

    fun findRoleByName (name : String?) : Role?
}