package com.terdev.dubas.bd.dubas.impl

import com.j256.ormlite.dao.BaseDaoImpl
import com.j256.ormlite.support.ConnectionSource
import com.terdev.dubas.bd.dubas.TobaccoDao
import com.terdev.dubas.bd.dubas.model.Tobacco

class TobaccoDaoImpl(connectionSource: ConnectionSource?) :
    BaseDaoImpl<Tobacco, Long>(connectionSource, Tobacco::class.java), TobaccoDao {

}