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
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name = "DBS_TOBACCO")
@Data
class Tobacco {

    companion object {
        const val generator = "SQ_DBS_TOBACCO_DBS_TOBACCO_ID"

        const val DBS_TOBACCO_ID: String = "DBS_TOBACCO_ID"
        const val ID_BRAND: String = "ID_BRAND"
        const val ID_LINE: String = "ID_LINE"
        const val NAME: String = "NAME"
        const val INSERT_DATE: String = "INSERT_DATE"
    }

    @Id
    @Column(name = DBS_TOBACCO_ID, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_tobaccoId")
    @SequenceGenerator(name = "generator_tobaccoId", sequenceName = generator, allocationSize = 1)
    var tobaccoId: Long? = null

    @ManyToOne(cascade= arrayOf(CascadeType.ALL))
    @JoinColumn(name = ID_BRAND, referencedColumnName = Brand.DBS_BRAND_ID)
    var brand: Brand? = null

    @ManyToOne(cascade= arrayOf(CascadeType.ALL))
    @JoinColumn(name = ID_LINE, referencedColumnName = Line.DBS_LINE_ID)
    var line: Line? = null

    @Column(name = NAME, nullable = false)
    var name: String? = null

    @Column(name = INSERT_DATE, insertable = false)
    var insert_date: Date? = null

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "tobacco", cascade = arrayOf(CascadeType.ALL))
    var tobaccoTags: List<TobaccoTag>? = null
}