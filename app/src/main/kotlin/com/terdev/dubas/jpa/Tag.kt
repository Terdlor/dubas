package com.terdev.dubas.jpa

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
@Table(name = "DBS_TAG")
@Data
class Tag {

    companion object {
        const val generator = "SQ_DBS_TAG_DBS_TAG_ID"

        const val NAME: String = "NAME"
        const val INSERT_DATE: String = "INSERT_DATE"
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator1")
    @SequenceGenerator(name = "generator1", sequenceName = generator, allocationSize = 1)
    var DBS_TAG_ID: Long? = null

    @Column(name = NAME, nullable = false)
    var name: String? = null

    @Column(name = INSERT_DATE, nullable = false)
    var insert_date: Date? = null
}