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
@Table(name = "DBS_TOBACCO_TAG")
@Data
class TobaccoTag {

    companion object {
        const val generator = "SQ_DBS_TOBACCO_TAG_DBS_TOBACCO_TAG_ID"

        const val ID_TOBACCO: String = "ID_TOBACCO"
        const val ID_TAG: String = "ID_TAG"
        const val INSERT_DATE: String = "INSERT_DATE"
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator1")
    @SequenceGenerator(name = "generator1", sequenceName = generator, allocationSize = 1)
    var DBS_TOBACCO_TAG_ID: Long? = null

    @Column(name = ID_TOBACCO, nullable = false)
    var idTobacco: Int = 1

    @Column(name = ID_TAG, nullable = false)
    var idTag: Int = 1

    @Column(name = INSERT_DATE)
    var insert_date: Date? = null
}