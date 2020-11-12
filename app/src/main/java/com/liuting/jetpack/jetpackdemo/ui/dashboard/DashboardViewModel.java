package com.liuting.jetpack.jetpackdemo.ui.dashboard;

import android.annotation.SuppressLint;
import android.app.Application;

import com.liuting.jetpack.jetpackdemo.base.BaseViewModel;
import com.liuting.jetpack.jetpackdemo.ui.dashboard.bean.NewsBean;
import com.liuting.jetpack.jetpackdemo.ui.dashboard.model.NewsRepository;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModel extends BaseViewModel {

    private MutableLiveData<List<NewsBean>> mListMutableLiveData=new MutableLiveData<>();

    public DashboardViewModel(@NonNull Application application) {
        super(application);
    }

    @SuppressLint("CheckResult")
    public void getTopNews(){
        NewsRepository.mInstance.getTopNewsTask().subscribe(
         data -> mListMutableLiveData.setValue(data.getData())
        );
    }

    public MutableLiveData<List<NewsBean>> getListMutableLiveData() {
        return mListMutableLiveData;
    }
}