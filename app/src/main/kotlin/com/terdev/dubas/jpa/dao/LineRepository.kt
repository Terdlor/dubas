package com.terdev.dubas.jpa.dao

import com.terdev.dubas.jpa.entity.Line
import org.springframework.data.jpa.repository.JpaRepository

interface LineRepository : JpaRepository<Line, Long> {

    fun findByName(name: String): Line

}