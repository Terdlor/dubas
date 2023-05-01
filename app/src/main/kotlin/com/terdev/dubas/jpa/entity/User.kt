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
@Table(name = "DBS_USER")
@Data
class User {

    companion object {
        const val generator = "SQ_DBS_USER_DBS_USER_ID"

        const val DBS_USER_ID: String = "DBS_USER_ID"
        const val ID: String = "ID"
        const val FIRST_NAME: String = "FIRST_NAME"
        const val IS_BOT: String = "IS_BOT"
        const val LAST_NAME: String = "LAST_NAME"
        const val USER_NAME: String = "USER_NAME"
        const val LANGUAGE_CODE: String = "LANGUAGE_CODE"
        const val ROLE: String = "ROLE"
        const val INSERT_DATE: String = "INSERT_DATE"
    }

    @Id
    @Column(name = DBS_USER_ID, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_userId")
    @SequenceGenerator(name = "generator_userId", sequenceName = generator, allocationSize = 1)
    var userId: Long? = null

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

    @Column(name = ROLE)
    var role: String? = null

    @Column(name = INSERT_DATE, insertable = false)
    var insert_date: Date? = null
}