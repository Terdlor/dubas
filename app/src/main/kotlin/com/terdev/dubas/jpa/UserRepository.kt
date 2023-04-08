package com.terdev.dubas.jpa

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {

    fun findByUserName(userName: String): User

}