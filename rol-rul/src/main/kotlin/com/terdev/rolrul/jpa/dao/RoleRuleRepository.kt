package com.terdev.rolrul.jpa.dao

import com.terdev.rolrul.jpa.entity.Role
import com.terdev.rolrul.jpa.entity.RoleRule
import com.terdev.rolrul.jpa.entity.Rule
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

interface RoleRuleRepository : JpaRepository<RoleRule, Long> {

    fun getRoleRuleByRoleAndRule(role: Role, rule: Rule): List<RoleRule>

    @Modifying
    @Query(value = "delete from RR_ROLE_RULE where id_role = :roleId and id_rule = :ruleId", nativeQuery = true)
    fun deleteAllByRoleAndRule(roleId: Long?, ruleId: Long?)
}