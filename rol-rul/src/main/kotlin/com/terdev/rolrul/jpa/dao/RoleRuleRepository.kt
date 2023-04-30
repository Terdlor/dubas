package com.terdev.rolrul.jpa.dao

import com.terdev.rolrul.jpa.entity.RoleRule
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRuleRepository : JpaRepository<RoleRule, Long>