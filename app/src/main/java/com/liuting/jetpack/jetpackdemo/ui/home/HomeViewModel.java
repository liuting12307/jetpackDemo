package com.liuting.jetpack.jetpackdemo.ui.home;

import android.annotation.SuppressLint;
import android.app.Application;

import com.liuting.jetpack.jetpackdemo.base.BaseViewModel;
import com.liuting.jetpack.jetpackdemo.ui.dashboard.bean.NewsBean;
import com.liuting.jetpack.jetpackdemo.ui.dashboard.model.NewsRepository;
import com.liuting.jetpack.jetpackdemo.ui.home.bean.AirCityBean;
import com.liuting.jetpack.jetpackdemo.ui.home.model.AirCityRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.functions.Consumer;

public class HomeViewModel extends BaseViewModel {
    private MutableLiveData<List<AirCityBean>> mListMutableLiveData=new MutableLiveData<>();

    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    @SuppressLint("CheckResult")
    public void getAirCitys(){
        AirCityRepository.mInstance.getAirCityList().subscribe(
                airCityBeans -> {
                    mListMutableLiveData.setValue(airCityBeans);
                }
        );
    }

    public MutableLiveData<List<AirCityBean>> getListMutableLiveData() {
        return mListMutableLiveData;
    }

}