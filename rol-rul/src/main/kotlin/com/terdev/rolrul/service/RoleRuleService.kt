package com.terdev.rolrul.service

import com.terdev.rolrul.common.RoleInterface
import com.terdev.rolrul.common.RuleInterface
import com.terdev.rolrul.jpa.dao.RoleRepository
import com.terdev.rolrul.jpa.dao.RoleRuleRepository
import com.terdev.rolrul.jpa.dao.RuleRepository
import com.terdev.rolrul.jpa.entity.Role
import com.terdev.rolrul.jpa.entity.RoleRule
import com.terdev.rolrul.jpa.entity.Rule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class RoleRuleService {

    @Autowired
    lateinit var roleRepository: RoleRepository

    @Autowired
    lateinit var ruleRepository: RuleRepository

    @Autowired
    lateinit var ruleRoleRepository: RoleRuleRepository

    private fun getRole(roles: RoleInterface): Role {
        return roleRepository.findRoleByName(roles.getName()) ?: with(Role()) {
            val role = Role()
            role.name = roles.getName()
            roleRepository.save(role)
        }
    }

    private fun getRule(ruleKeys: RuleInterface): Rule {
        return ruleRepository.findRuleByKey(ruleKeys.getKey()) ?: with(Rule()) {
            val rule = Rule()
            rule.key = ruleKeys.getKey()
            rule.name = ruleKeys.getName()
            ruleRepository.save(rule)
        }
    }

    @Transactional
    fun addRuleInRole(roles: RoleInterface, ruleKeys: RuleInterface) {
        val rule = getRule(ruleKeys)
        val role = getRole(roles)
        if ((role.roleRule?.filter { it.rule?.ruleId == rule.ruleId }?.count() ?: 0) <= 0) {
            val ruleRole = RoleRule()
            ruleRole.rule = rule
            ruleRole.role = role
            ruleRoleRepository.save(ruleRole)
        }
    }

    @Transactional
    fun deleteRuleInRole(roles: RoleInterface, ruleKeys: RuleInterface) {
        val role = getRole(roles)
        val rule = getRule(ruleKeys)
        ruleRoleRepository.deleteAllByRoleAndRule(role.roleId, rule.ruleId)
    }

    fun checkRuleInRole(roles: RoleInterface, ruleKeys: RuleInterface): Boolean {
        val role = getRole(roles)
        val rule = getRule(ruleKeys)
        return (role.roleRule?.filter { it.rule?.ruleId == rule.ruleId }?.count() ?: 0) > 0
    }

    fun getRuleFromRole(roles: RoleInterface): List<RuleInterface> {
        val role = getRole(roles)
        val result = ArrayList<RuleInterface>()
        role.roleRule?.forEach {
            if (it.rule?.key != null) {
                result.add(RuleInternal(it.rule!!.key!!, it.rule!!.name ?: "Не указано"))
            }
        }
        return result
    }

    private class RuleInternal(var keyInternal: String, var nameInternal: String) : RuleInterface {
        override fun getName() = nameInternal
        override fun getKey() = keyInternal
    }
}