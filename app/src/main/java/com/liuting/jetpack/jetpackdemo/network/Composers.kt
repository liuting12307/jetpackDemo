package com.liuting.jetpack.jetpackdemo.network

import android.util.Log
import android.view.View
import com.fashare.net.exception.ExceptionFactory
import com.qchat.base.net.exception.ApiException
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


object Composers {
    private val TAG = "Composers"

    fun <T> handleError(): ObservableTransformer<BaseNetworkBean<T>, T> {
        return handleError(true)
    }

    /**
     *
     * @param isShowToast Boolean 是否需要显示toast
     * @return ObservableTransformer<Response<T>, T>
     */
    private fun <T> handleError(isShowToast: Boolean): ObservableTransformer<BaseNetworkBean<T>, T> {
        return ObservableTransformer { observable ->
            observable.map { responseModel ->
                Log.e(TAG,"responseModel.error_code"+responseModel.error_code)
                if (responseModel.error_code == 0) {
                    if (responseModel.result == null) {
                        return@map VoidEntity(responseModel.error_code, responseModel.reason) as T
                    } else {
                        return@map responseModel.result
                    }
                } else {
                    throw ExceptionFactory.ServerException(
                        responseModel.error_code ?: -1,
                        responseModel.reason ?: "网络似乎出现了问题"
                    )
                }
            }.onErrorResumeNext { throwable: Throwable ->
                Log.e(TAG, "onErrorResumeNext---$throwable")
                Observable.error(ExceptionFactory.create(throwable))
            }
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError { e: Throwable ->
                    Log.e(TAG, "doOnError$e")
                    (e as? ApiException)?.apply {
                        // 登录失效
                        Log.e(TAG, "errorCode$errorCode")
                    }
                }
        }
    }
}
