package com.terdev.dubas.bd.system

import com.j256.ormlite.dao.Dao
import com.terdev.dubas.bd.system.model.DbInfo
import java.sql.SQLException

interface DbInfoDao : Dao<DbInfo, Long> {

    @Throws(SQLException::class)
    fun save(ver: Long)

    @Throws(SQLException::class)
    fun lastVersion(): Long
}