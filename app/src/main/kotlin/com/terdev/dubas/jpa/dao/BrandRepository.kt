package com.terdev.dubas.jpa.dao

import com.terdev.dubas.jpa.entity.Brand
import org.springframework.data.jpa.repository.JpaRepository

interface BrandRepository : JpaRepository<Brand, Long> {

    fun findByName(name: String): Brand

}