package com.terdev.dubas.jpa.dao

import com.terdev.dubas.jpa.entity.Tag
import org.springframework.data.jpa.repository.JpaRepository

interface TagRepository : JpaRepository<Tag, Long> {

    fun findByName(name: String): Tag

}