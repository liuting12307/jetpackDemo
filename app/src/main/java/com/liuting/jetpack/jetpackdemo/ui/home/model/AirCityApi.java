package com.liuting.jetpack.jetpackdemo.ui.home.model;

import com.liuting.jetpack.jetpackdemo.network.BaseNetworkBean;
import com.liuting.jetpack.jetpackdemo.ui.dashboard.bean.NewsData;
import com.liuting.jetpack.jetpackdemo.ui.home.bean.AirCityBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 作者:admin on 2020/10/18 15:20
 * 邮箱:474211389@qq.com
 * 项目名：JetpackDemo
 * 包名：com.liuting.jetpack.jetpackdemo.ui.dashboard.model
 * TODO:
 */
interface AirCityApi {


    @GET("/simpleWeather/cityList")
    Observable<BaseNetworkBean<List<AirCityBean>>> getCitys(@Query("key") String key);
}
