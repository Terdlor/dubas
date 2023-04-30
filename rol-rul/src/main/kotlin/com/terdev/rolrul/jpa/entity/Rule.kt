package com.terdev.rolrul.jpa.entity

import lombok.Data
import java.util.*
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name = "RR_RULE")
@Data
class Rule {

    companion object {
        const val generator = "SQ_RR_RULE_RR_RULE_ID"

        const val RR_RULE_ID: String = "RR_RULE_ID"
        const val KEY: String = "KEY"
        const val NAME: String = "NAME"
        const val INSERT_DATE: String = "INSERT_DATE"
    }

    @Id
    @Column(name = RR_RULE_ID, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_ruleId")
    @SequenceGenerator(name = "generator_ruleId", sequenceName = generator, allocationSize = 1)
    var ruleId: Long? = null

    @Column(name = KEY, nullable = false)
    var key: String? = null

    @Column(name = NAME, nullable = false)
    var name: String? = null

    @Column(name = INSERT_DATE, insertable = false)
    var insert_date: Date? = null

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "rule", cascade = arrayOf(CascadeType.ALL))
    var roleRule: List<RoleRule>? = null
}