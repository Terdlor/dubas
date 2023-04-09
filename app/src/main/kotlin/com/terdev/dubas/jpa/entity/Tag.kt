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
@Table(name = "DBS_TAG")
@Data
class Tag {

    companion object {
        const val generator = "SQ_DBS_TAG_DBS_TAG_ID"

        const val DBS_TAG_ID: String = "DBS_TAG_ID"
        const val NAME: String = "NAME"
        const val INSERT_DATE: String = "INSERT_DATE"
    }

    @Id
    @Column(name = DBS_TAG_ID, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_tagId")
    @SequenceGenerator(name = "generator_tagId", sequenceName = generator, allocationSize = 1)
    var tagId: Long? = null

    @Column(name = NAME, nullable = false)
    var name: String? = null

    @Column(name = INSERT_DATE)
    var insert_date: Date? = null

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "tag", cascade = arrayOf(CascadeType.ALL))
    var tobaccoTags: List<TobaccoTag>? = null
}