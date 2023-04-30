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
@Table(name = "RR_ROLE")
@Data
class Role {

    companion object {
        const val generator = "SQ_RR_ROLE_RR_ROLE_ID"

        const val RR_ROLE_ID: String = "RR_ROLE_ID"
        const val IS_ADMIN: String = "IS_ADMIN"
        const val NAME: String = "NAME"
        const val INSERT_DATE: String = "INSERT_DATE"
    }

    @Id
    @Column(name = RR_ROLE_ID, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_roleId")
    @SequenceGenerator(name = "generator_roleId", sequenceName = generator, allocationSize = 1)
    var ruleId: Long? = null

    @Column(name = IS_ADMIN, nullable = false, insertable = false)
    var isAdmin: Boolean? = null

    @Column(name = NAME, nullable = false)
    var name: String? = null

    @Column(name = INSERT_DATE, insertable = false)
    var insert_date: Date? = null

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "role", cascade = arrayOf(CascadeType.ALL))
    var roleRule: List<RoleRule>? = null
}