package com.liuting.jetpack.jetpackdemo.network

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.ResponseBody
import java.util.*

class NetEntry private constructor() {
    companion object {
        private var instance: NetEntry? = null
            get() {
                if (field == null) {
                    field = NetEntry()
                }
                return field
            }

        fun get(): NetEntry {
            //细心的小伙伴肯定发现了，这里不用getInstance作为为方法名，是因为在伴生对象声明时，内部已有getInstance方法，所以只能取其他名字
            return instance!!
        }

        val GSON = Gson()
    }

    fun initDataBase() {
      //  ApiFactory.okhttpClient = OkHttpClient()
        ApiFactory.okhttpClient=OkHttpFactory.create(LogInterceptor(),true);
//        ApiFactory.okhttpClient = OkHttpFactory.create(Interceptor { it ->
//            val originRequest = it.request()
//            val treeMap = TreeMap<String, String>()
//            treeMap[""] = DeviceUtils.getAndroidID()
//            treeMap["deviceType"] = "4"
//            treeMap["timestamp"] = System.currentTimeMillis().toString()
//            treeMap["version"] = PackageUtils.getVersion(AppManager.getsApplication())
//
//            val keys: Set<String> = treeMap.keys
//            //构造正确的url
//            var signUrl = ""
//            for (key in keys) {
//                signUrl += key + "=" + treeMap[key] + "&"
//            }
//            val sign =
//                MD5Util.getMd5(signUrl.substring(0, signUrl.length - 1) + "seektop-qchat")
//            // 添加 header 以及公共的 GET 参数
//            var builder: Request.Builder = originRequest.newBuilder();
//            for (item: String in treeMap.keys) {
//                builder.addHeader(item, treeMap.get(item))
//            }
//            builder.addHeader("sign", sign)
//            //提取用户信息
//            val provider = ModuleFactory.getLoginProvider()
//            provider?.getLoginInfo()?.let {
//                builder.addHeader("token", it.apiAuthToken)
//                builder.addHeader("uid", it.userId.toString())
//            }

//            val newRequest = builder
//                .url(
//                    originRequest.url.newBuilder()
//                        .build()
//                ).build()
//
//
//            it.proceed(originRequest)
//            response.newBuilder()
//                .apply {
//                    val originBody = response.body
//                    var json = originBody?.string()
//                    var res: Response<Any>? = null
//
//                    try {
//
//                        res = GSON.fromJson(json, object : TypeToken<Response<Any>>() {}.type)
//                    } catch (e: Exception) {
//                        Log.e("initNet", "interceptor response" + e)
//                    }
//
//                    try {
//                        res = GSON.fromJson(json, object : TypeToken<Response<List<Any>>>() {}.type)
//                    } catch (e: Exception) {
//                        Log.e("initNet", "interceptor response" + e)
//                    }

                    // 不成功，则移除 "d" 字段
//                    if (1 != res?.code) {
//                        if (405 == res?.code) {//登录失效
//                            ScreenManager.stopLockScreen()
//                            WebSocketHandler.getDefault().disConnect()
//                            GlobalScope.launch(Dispatchers.Main) {
//                                if (ActivityUtils.getTopActivity() == null) {
//                                    return@launch
//                                }
//                                DialogUtils.showSureDialog(
//                                    ActivityUtils.getTopActivity(),
//                                    AppManager.getsApplication()
//                                        .getString(R.string.token_past_hint_title),
//                                    object : DialogUtils.OnSureClickListener {
//                                        override fun onSureClick(dialog: Dialog) {
//                                            ModuleFactory.getLoginProvider()
//                                                .startLogin(
//                                                    AppManager.getTopActivityOrApp(),
//                                                    FROM_ELSE
//                                                )
//                                            ActivityUtils.finishAllActivities()
//                                        }
//
//                                    },
//                                    false,
//                                    ActivityUtils.getTopActivity().getString(R.string.know),
//                                    AppManager.getsApplication()
//                                        .getString(R.string.token_past_hint),
//                                    true
//                                )
//                            }

//                            ToastUtils.showShort(res?.message)
//                            //token解析失败
//                            stopLockScreen()
//                            AppManager.finishAllActivity()
//                            ModuleFactory.getLoginProvider().startLogin(AppManager.getTopActivityOrApp(),FROM_ELSE)

//                        }


//                        if(106==res?.code&&res?.data==true){
//                            deleteDatas()
//                            ScreenManager.stopLockScreen()
//                            WebSocketHandler.getDefault().disConnect()
//                            DialogUtils.showSureDialog(
//                                ActivityUtils.getTopActivity(),
//                                AppManager.getsApplication().getString(R.string.account_abnormal_hint_title),
//                                object : DialogUtils.OnSureClickListener{
//                                    override fun onSureClick(dialog: Dialog) {
//                                        ModuleFactory.getLoginProvider()
//                                            .startLogin(AppManager.getTopActivityOrApp(), FROM_ELSE)
//                                        ActivityUtils.finishAllActivities()
//                                    }
//
//                                },
//                                false,
//                                ActivityUtils.getTopActivity().getString(R.string.know),
//                                AppManager.getsApplication().getString(R.string.account_abnormal_hint),
//                                true
//                            )
//                        }
//                        res?.data = null
//                    }
//                    json = GSON.toJson(res)
//
//                    this.body(ResponseBody.create(originBody?.contentType(), json))
//                }
//                .apply {
//                    this.code(if (response.code in 400..500) 200 else response.code)
//                }
//                .build()
//        })


    }

}