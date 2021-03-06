package com.qchat.base.net.exception

/**
 * 对外统一的异常
 */
class ApiException(throwable: Throwable,
                   val errorCode: Int,
                   var errorMsg: String? = null) : Exception(throwable) {

    override val message: String?
        get() = errorMsg?:localizedMessage
}
