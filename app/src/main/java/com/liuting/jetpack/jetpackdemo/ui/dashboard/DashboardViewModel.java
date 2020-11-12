package com.liuting.jetpack.jetpackdemo.ui.dashboard;

import android.annotation.SuppressLint;
import android.util.Log;

import com.liuting.jetpack.jetpackdemo.base.BaseViewModel;
import com.liuting.jetpack.jetpackdemo.ui.dashboard.bean.NewsBean;
import com.liuting.jetpack.jetpackdemo.ui.dashboard.model.NewsRepository;
import com.qchat.base.net.exception.ApiException;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.functions.Consumer;

public class DashboardViewModel extends BaseViewModel {

    private String TAG=getClass().getSimpleName();

    private MutableLiveData<List<NewsBean>> mListMutableLiveData=new MutableLiveData<>();

    @SuppressLint("CheckResult")
    public void getTopNews(){
        NewsRepository.mInstance.getTopNewsTask().subscribe(
                data -> mListMutableLiveData.setValue(data.getData()), throwable -> {
                    Log.e(TAG,throwable.toString());
                    ApiException apiException= (ApiException) throwable;
                    Log.e(TAG,"apiException.getErrorCode="+apiException.getErrorCode());
                }
        );
    }

    public MutableLiveData<List<NewsBean>> getListMutableLiveData() {
        return mListMutableLiveData;
    }
}