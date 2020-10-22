package com.liuting.jetpack.jetpackdemo.network

import java.io.Serializable

/**
 * 此实体类用于对部分网络数据无data字段的映射
 * 同时继承于Any
 */
class VoidEntity(var code:Int? = 0, val messsge:String): Any(),Serializable