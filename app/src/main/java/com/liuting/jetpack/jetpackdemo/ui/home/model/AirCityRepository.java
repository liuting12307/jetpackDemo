package com.liuting.jetpack.jetpackdemo.ui.home.model;

import com.liuting.jetpack.jetpackdemo.network.ApiFactory;
import com.liuting.jetpack.jetpackdemo.network.BaseNetworkBean;
import com.liuting.jetpack.jetpackdemo.network.Composers;
import com.liuting.jetpack.jetpackdemo.ui.dashboard.bean.NewsData;
import com.liuting.jetpack.jetpackdemo.ui.home.bean.AirCityBean;

import java.util.List;

import io.reactivex.Observable;

/**
 * 作者:admin on 2020/10/18 15:21
 * 邮箱:474211389@qq.com
 * 项目名：JetpackDemo
 * 包名：
 * TODO:
 */
public class AirCityRepository {
    public static AirCityRepository mInstance = new AirCityRepository();

    private AirCityRepository() {

    }

    public Observable<List<AirCityBean>> getAirCityList(){
        ApiFactory.INSTANCE.setMBaseUrl("http://apis.juhe.cn");
        Observable<BaseNetworkBean<List<AirCityBean>>> citys = ApiFactory.INSTANCE.getApi(AirCityApi.class).getCitys("3c373d9edc06dfafdb47380fce84b4");
        return citys.compose(Composers.INSTANCE.handleError());
//        return ApiFactory.INSTANCE.getApi(AirCityApi.class).getCitys("2c040ea34f27e968532d36caa5485836")
//                .compose(Composers.INSTANCE.handleError());
    }

}
