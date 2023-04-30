package com.terdev.rolrul.jpa.entity

import lombok.Data
import java.util.*
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name = "RR_ROLE_RULE")
@Data
class RoleRule {

    companion object {
        const val generator = "SQ_RR_ROLE_RULE_RR_ROLE_RULE_ID"

        const val RR_ROLE_RULE_ID: String = "RR_ROLE_RULE_ID"
        const val ID_ROLE: String = "ID_ROLE"
        const val ID_RULE: String = "ID_RULE"
        const val INSERT_DATE: String = "INSERT_DATE"
    }

    @Id
    @Column(name = RR_ROLE_RULE_ID, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_roleruleId")
    @SequenceGenerator(name = "generator_roleruleId", sequenceName = generator, allocationSize = 1)
    var roleRuleId: Long? = null

    @ManyToOne
    @JoinColumn(name = ID_ROLE, referencedColumnName = Role.RR_ROLE_ID)
    var role: Role? = null

    @ManyToOne
    @JoinColumn(name = ID_RULE, referencedColumnName = Rule.RR_RULE_ID)
    var rule: Rule? = null

    @Column(name = INSERT_DATE, insertable = false)
    var insert_date: Date? = null
}