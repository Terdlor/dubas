package com.terdev.dubas.bd.dubas.impl

import com.j256.ormlite.dao.BaseDaoImpl
import com.j256.ormlite.support.ConnectionSource
import com.terdev.dubas.bd.dubas.LineDao
import com.terdev.dubas.bd.dubas.model.Line

class LineDaoImpl(connectionSource: ConnectionSource?) : BaseDaoImpl<Line, Long>(connectionSource, Line::class.java),
    LineDao {

}