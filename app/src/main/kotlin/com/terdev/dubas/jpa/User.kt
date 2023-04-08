package com.terdev.dubas.jpa


import lombok.Data
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

        const val ID: String = "id"
        const val FIRST_NAME: String = "first_name"
        const val IS_BOT: String = "is_bot"
        const val LAST_NAME: String = "last_name"
        const val USER_NAME: String = "user_name"
        const val LANGUAGE_CODE: String = "language_code"
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

}