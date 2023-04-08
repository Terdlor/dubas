package com.terdev.dubas.jpa.dao

import com.terdev.dubas.jpa.entity.Tobacco
import org.springframework.data.jpa.repository.JpaRepository

interface TobaccoRepository : JpaRepository<Tobacco, Long> {

    fun findByName(name: String): Tobacco

}