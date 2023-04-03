package com.terdev.dubas.bd.dubas.impl

import com.j256.ormlite.dao.BaseDaoImpl
import com.j256.ormlite.support.ConnectionSource
import com.terdev.dubas.bd.dubas.TagDao
import com.terdev.dubas.bd.dubas.model.Tag

class TagDaoImpl(connectionSource: ConnectionSource?) : BaseDaoImpl<Tag, Long>(connectionSource, Tag::class.java),
    TagDao {

}