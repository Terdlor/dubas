package com.terdev.rolrul.jpa.dao

import com.terdev.rolrul.jpa.entity.Rule
import org.springframework.data.jpa.repository.JpaRepository

interface RuleRepository : JpaRepository<Rule, Long> {

    fun findRuleByKey(key : String?) : Rule?
}