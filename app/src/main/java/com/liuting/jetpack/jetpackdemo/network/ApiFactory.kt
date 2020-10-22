package com.liuting.jetpack.jetpackdemo.network


import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object ApiFactory {

    val Tag = "ApiFactory"
    /**
     * baseUrl of each Api
     */
    var mBaseUrl="http://v.juhe.cn";

    var okhttpClient = OkHttpFactory.client

    private val mRetrofitBuilder: Retrofit.Builder by lazy {
        Log.d(Tag,okhttpClient.toString())
        Retrofit.Builder()
                .client(okhttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    }

    fun <T> getApi(clazz: Class<T>): T {

        return mRetrofitBuilder.baseUrl(mBaseUrl).build().create(clazz)
    }
}