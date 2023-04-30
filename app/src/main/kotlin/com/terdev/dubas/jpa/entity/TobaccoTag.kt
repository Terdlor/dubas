package com.terdev.dubas.jpa.entity

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
@Table(name = "DBS_TOBACCO_TAG")
@Data
class TobaccoTag {

    companion object {
        const val generator = "SQ_DBS_TOBACCO_TAG_DBS_TOBACCO_TAG_ID"

        const val DBS_TOBACCO_TAG_ID: String = "DBS_TOBACCO_TAG_ID"
        const val ID_TOBACCO: String = "ID_TOBACCO"
        const val ID_TAG: String = "ID_TAG"
        const val INSERT_DATE: String = "INSERT_DATE"
    }

    @Id
    @Column(name = DBS_TOBACCO_TAG_ID, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_tobaccoTagId")
    @SequenceGenerator(name = "generator_tobaccoTagId", sequenceName = generator, allocationSize = 1)
    var tobaccoTagId: Long? = null

    @ManyToOne(cascade= arrayOf(CascadeType.ALL))
    @JoinColumn(name = ID_TOBACCO, referencedColumnName = Tobacco.DBS_TOBACCO_ID)
    var tobacco: Tobacco? = null

    @ManyToOne(cascade= arrayOf(CascadeType.ALL))
    @JoinColumn(name = ID_TAG, referencedColumnName = Tag.DBS_TAG_ID)
    var tag: Tag? = null

    @Column(name = INSERT_DATE, insertable = false)
    var insert_date: Date? = null
}