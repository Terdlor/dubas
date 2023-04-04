package com.terdev.dubas.bd.dubas.impl

import com.j256.ormlite.dao.BaseDaoImpl
import com.j256.ormlite.support.ConnectionSource
import com.terdev.dubas.bd.dubas.TobaccoTagDao
import com.terdev.dubas.bd.dubas.model.TobaccoTag

class TobaccoTagDaoImpl(connectionSource: ConnectionSource?) :
    BaseDaoImpl<TobaccoTag, Long>(connectionSource, TobaccoTag::class.java), TobaccoTagDao {

}