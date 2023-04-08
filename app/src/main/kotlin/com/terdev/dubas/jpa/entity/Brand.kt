package com.terdev.dubas.jpa.entity

import lombok.Data
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Table


@Entity
@Table(name = "DBS_BRAND")
@Data
class Brand {

    companion object {
        const val generator = "SQ_DBS_BRAND_DBS_BRAND_ID"

        const val NAME: String = "NAME"
        const val HAS_LINE: String = "HAS_LINE"
        const val INSERT_DATE: String = "INSERT_DATE"
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator1")
    @SequenceGenerator(name = "generator1", sequenceName = User.generator, allocationSize = 1)
    var DBS_BRAND_ID: Long? = null

    @Column(name = NAME, nullable = false)
    var name: String? = null

    @Column(name = HAS_LINE, nullable = false)
    var hasLines: Boolean = false

    @Column(name = INSERT_DATE)
    var insert_date: Date? = null
}