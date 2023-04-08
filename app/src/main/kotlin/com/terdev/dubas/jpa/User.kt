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
@Table(name = "DBS_USER")
@Data
class User {

    companion object {
        const val generator = "SQ_DBS_USER_DBS_USER_ID"

        const val ID: String = "ID"
        const val FIRST_NAME: String = "FIRST_NAME"
        const val IS_BOT: String = "IS_BOT"
        const val LAST_NAME: String = "LAST_NAME"
        const val USER_NAME: String = "USER_NAME"
        const val LANGUAGE_CODE: String = "LANGUAGE_CODE"
        const val INSERT_DATE: String = "INSERT_DATE"
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator1")
    @SequenceGenerator(name = "generator1", sequenceName = generator, allocationSize = 1)
    var DBS_USER_ID: Long? = null

    @Column(name = ID, nullable = false)
    var id: Long? = null

    @Column(name = FIRST_NAME, nullable = false)
    var firstName: String? = null

    @Column(name = IS_BOT, nullable = false)
    var isBot: Boolean? = null

    @Column(name = LAST_NAME, nullable = false)
    var lastName: String? = null

    @Column(name = USER_NAME, nullable = false)
    var userName: String? = null

    @Column(name = LANGUAGE_CODE, nullable = false)
    var languageCode: String? = null

    @Column(name = INSERT_DATE, nullable = false)
    var insert_date: Date? = null
}