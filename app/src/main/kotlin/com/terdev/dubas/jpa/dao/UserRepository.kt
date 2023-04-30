package com.terdev.dubas.jpa.dao

import com.terdev.dubas.jpa.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {

    fun findByUserName(userName: String): User?

}