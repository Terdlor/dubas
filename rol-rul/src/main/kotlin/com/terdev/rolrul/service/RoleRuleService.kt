package com.terdev.rolrul.service

import com.terdev.rolrul.common.RolRulException
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
import java.util.*

@Component
class RoleRuleService {

    @Autowired
    lateinit var roleRepository: RoleRepository

    @Autowired
    lateinit var ruleRepository: RuleRepository

    @Autowired
    lateinit var ruleRoleRepository: RoleRuleRepository

    private fun getRole(roleName: String): Role {
        return roleRepository.findRoleByName(roleName) ?: with(Role()) {
            val role = Role()
            role.name = roleName
            roleRepository.save(role)
        }
    }

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

    fun addRuleInRole(roleName: String?, ruleKeys: RuleInterface) {
        if (roleName == null) throw RolRulException("Невозможно добавить в пустую роль")
        addRuleInRoleDb(getRole(roleName), ruleKeys)
    }

    fun addRuleInRole(roles: RoleInterface, ruleKeys: RuleInterface) {
        addRuleInRoleDb(getRole(roles), ruleKeys)
    }

    private fun addRuleInRoleDb(role: Role,  ruleKeys: RuleInterface) {
        val rule = getRule(ruleKeys)
        if ((role.roleRule?.filter { it.rule?.ruleId == rule.ruleId }?.count() ?: 0) <= 0) {
            val ruleRole = RoleRule()
            ruleRole.rule = rule
            ruleRole.role = role
            ruleRoleRepository.save(ruleRole)
        }
    }

    fun checkRuleInRole(roles: RoleInterface, ruleKeys: RuleInterface): Boolean {
        return  checkRuleInRoleDb(getRole(roles), ruleKeys)
    }

    fun checkRuleInRole(roleName: String?, ruleKeys: RuleInterface): Boolean {
        if (roleName == null) return false
        return checkRuleInRoleDb(getRole(roleName), ruleKeys)
    }

    private fun checkRuleInRoleDb(role: Role, ruleKeys: RuleInterface) : Boolean{
        val rule = getRule(ruleKeys)
        return (role.roleRule?.filter { it.rule?.ruleId == rule.ruleId }?.count() ?: 0) > 0
    }

    fun getRuleFromRole(roleName: String?): List<RuleInterface> {
        if (roleName == null) return Collections.emptyList()
        return getRuleFromRoleDb(getRole(roleName))
    }

    fun getRuleFromRole(roles: RoleInterface): List<RuleInterface> {
        return getRuleFromRoleDb(getRole(roles))
    }

    private fun getRuleFromRoleDb(role: Role): List<RuleInterface> {
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