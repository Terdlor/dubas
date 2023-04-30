package com.terdev.dubas.jpa.entity

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
@Table(name = "DBS_BRAND")
@Data
class Brand {

    companion object {
        const val generator = "SQ_DBS_BRAND_DBS_BRAND_ID"

        const val DBS_BRAND_ID: String = "DBS_BRAND_ID"
        const val NAME: String = "NAME"
        const val HAS_LINE: String = "HAS_LINE"
        const val INSERT_DATE: String = "INSERT_DATE"
    }

    @Id
    @Column(name = DBS_BRAND_ID, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_brandId")
    @SequenceGenerator(name = "generator_brandId", sequenceName  = generator, allocationSize = 1)
    var brandId: Long? = null

    @Column(name = NAME, nullable = false)
    var name: String? = null

    @Column(name = HAS_LINE, nullable = false)
    var hasLines: Boolean = false

    @Column(name = INSERT_DATE, insertable = false)
    var insert_date: Date? = null

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "brand", cascade = arrayOf(CascadeType.ALL))
    var lines: List<Line>? = null

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "brand", cascade = arrayOf(CascadeType.ALL))
    var tobaccos: List<Tobacco>? = null
}