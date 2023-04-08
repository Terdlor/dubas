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
@Table(name = "DBS_TOBACCO")
@Data
class Tobacco {

    companion object {
        const val generator = "SQ_DBS_TOBACCO_DBS_TOBACCO_ID"

        const val ID_BREND: String = "ID_BREND"
        const val ID_LINE: String = "ID_LINE"
        const val NAME: String = "NAME"
        const val INSERT_DATE: String = "INSERT_DATE"
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator1")
    @SequenceGenerator(name = "generator1", sequenceName = generator, allocationSize = 1)
    var DBS_TOBACCO_ID: Long? = null

    @Column(name = ID_BREND, nullable = false)
    var idBrand: Int = 1

    @Column(name = ID_LINE, nullable = false)
    var idLine: Int = 1

    @Column(name = NAME, nullable = false)
    var name: String? = null

    @Column(name = INSERT_DATE)
    var insert_date: Date? = null
}