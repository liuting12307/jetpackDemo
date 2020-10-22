package com.liuting.jetpack.jetpackdemo.network

import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object OkHttpFactory {

    val TAG = "OkHttpFactory"

    /**
     * 整个api 请过超时时间
     *
     */
    var CALL_TIMEOUT_SECONDS = 0L

    /**
     * 他指的是从客户端发出一个请求开始到客户端与服务器端完成 TCP 的 3 次握手建立连接的这段时间
     */
    var CONNECTION_TIMEOUT_SECONDS = 30L

    /**
     * READ Timeout - 写入超时
     * 连接建立成功开始，Retrofit 就会监测每个字节的数据传输的速率。如果其中某自己距离上一字节传输成功的时间大于指定的 readTimeout 了，Retrofit 就会认为这个请求是失败的。这个时间计数器会在读取到每个 byte 之后归零重新开始计时。所以如果你的响应当中有 120 个 bytes 需要传输到客户端，而每个 byte 的传输都需要 5 秒，这种情况下尽管完全传输需要 600 秒，但不会触发 readTimeout（30 秒）error。
     */
    var READ_TIMEOUT_SECONDS = 20L

    /**
     * Write Timeout - 写入超时
     * 客户端向服务器端发送数据的速率。当然，跟 readTimeout的计时器类似，每个 byte 发送成功之后这个计时器都会被重置
     */
    var WRITE_TIMEOUT_SECONDS = 20L


    val client: OkHttpClient? = null

    fun create(customInterceptor: Interceptor, enableLog: Boolean = true): OkHttpClient {
        val sslParams = HttpsUtil.getSslSocketFactory(null, null, null)
        val loggingInterceptor = HttpLoggingInterceptor { chain, msg ->
            Log.d(TAG, "okhttp-${chain.request().url.toUri().path}" + msg);
        }.apply {
            this.level = com.liuting.jetpack.jetpackdemo.network.HttpLoggingInterceptor.Level.NONE
        }

        return OkHttpClient.Builder()
                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                .connectTimeout(CONNECTION_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .apply {
                    this.addInterceptor(customInterceptor)
                }
                .apply {
                    if (enableLog)
                        this.addInterceptor(loggingInterceptor)
                }
                .build()
    }


}