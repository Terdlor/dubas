package com.terdev.dubas.rolerule

import com.terdev.rolrul.common.RuleInterface

enum class RuleKeys(private val key: String) : RuleInterface {

    GET_BRENDS("GetBrends");

    override fun getKey() = key

    override fun getName() = name


}