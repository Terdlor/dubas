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
@Table(name = "DBS_LINE")
@Data
class Line {

    companion object {
        const val generator = "SQ_DBS_LINE_DBS_LINE_ID"

        const val ID_BRAND: String = "ID_BRAND"
        const val NAME: String = "NAME"
        const val INSERT_DATE: String = "INSERT_DATE"
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator1")
    @SequenceGenerator(name = "generator1", sequenceName = generator, allocationSize = 1)
    var DBS_LINE_ID: Long? = null

    @Column(name = ID_BRAND, nullable = false)
    var idBrand: Int = 1

    @Column(name = NAME, nullable = false)
    var name: String? = null

    @Column(name = INSERT_DATE)
    var insert_date: Date? = null
}