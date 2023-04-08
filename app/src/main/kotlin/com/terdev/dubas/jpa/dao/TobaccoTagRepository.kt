package com.terdev.dubas.jpa.dao

import com.terdev.dubas.jpa.entity.TobaccoTag
import org.springframework.data.jpa.repository.JpaRepository

interface TobaccoTagRepository : JpaRepository<TobaccoTag, Long> {

}