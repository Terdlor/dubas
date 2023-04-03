package com.terdev.dubas.bd.dubas.impl

import com.j256.ormlite.dao.BaseDaoImpl
import com.j256.ormlite.support.ConnectionSource
import com.terdev.dubas.bd.dubas.BrandDao
import com.terdev.dubas.bd.dubas.model.Brand

class BrandDaoImpl(connectionSource: ConnectionSource?) : BaseDaoImpl<Brand, Long>(connectionSource, Brand::class.java),
    BrandDao {

}