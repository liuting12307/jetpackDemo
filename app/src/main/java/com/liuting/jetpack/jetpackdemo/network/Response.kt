package com.liuting.jetpack.jetpackdemo.network

import com.google.gson.Gson

/**
 * Response 返回结果
 */
class Response<T> {
    companion object Initializer {
        private val GSON: Gson by lazy { Gson() }
    }

    var code = -1          // errorCode
    var message = ""          // errorMsg
    var data: T? = null    // data

    override fun toString(): String {
        return GSON.toJson(this)
    }
}
