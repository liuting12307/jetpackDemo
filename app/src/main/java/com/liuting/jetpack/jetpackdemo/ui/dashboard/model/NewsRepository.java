package com.liuting.jetpack.jetpackdemo.ui.dashboard.model;

import com.liuting.jetpack.jetpackdemo.network.ApiFactory;
import com.liuting.jetpack.jetpackdemo.ui.dashboard.bean.NewsBean;
import com.liuting.jetpack.jetpackdemo.network.Composers;
import com.liuting.jetpack.jetpackdemo.ui.dashboard.bean.NewsData;


import java.util.List;

import io.reactivex.Observable;

/**
 * 作者:admin on 2020/10/18 15:21
 * 邮箱:474211389@qq.com
 * 项目名：JetpackDemo
 * 包名：com.liuting.jetpack.jetpackdemo.ui.dashboard.model
 * TODO:
 */
public class NewsRepository {
    public static NewsRepository mInstance = new NewsRepository();

    private NewsRepository() {

    }

    public Observable<NewsData> getTopNewsTask(){
        ApiFactory.INSTANCE.setMBaseUrl("http://v.juhe.cn");
        return ApiFactory.INSTANCE.getApi(NewsApi.class).getTopNews("2c040ea34f27e968532d36caa5485836")
                .compose(Composers.INSTANCE.handleError());
    }

}
