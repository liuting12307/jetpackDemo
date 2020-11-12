package com.liuting.jetpack.jetpackdemo.base;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

/**
 * 作者:admin on 2020/10/17 11:57
 * 邮箱:474211389@qq.com
 * 项目名：JetpackDemo
 * 包名：com.liuting.jetpack.jetpackdemo.base
 * TODO:
 */
public class BaseViewModel extends AndroidViewModel {
    private BaseViewModel.UIChangeLiveData ui;

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    public BaseViewModel.UIChangeLiveData getUi() {
        if (this.ui == null) {
            this.ui = new UIChangeLiveData();
        }

        return this.ui;
    }

    public void startActivity(Class<?> cls) {
        startActivity(cls, (Bundle) null);
    }

    public void startActivity(Class<?> cls, Bundle bundle) {
        Map<String, Object> params = new HashMap();
        params.put(BaseViewModel.ParameterField.CLASS, cls);
        if (bundle != null) {
            params.put(BaseViewModel.ParameterField.BUNDLE, bundle);
        }

        this.ui.startActivityEvent.postValue(params);
    }

    public void showLoading() {
        showLoading("");
    }

    public void showLoading(String text) {
        this.ui.showLoadingEvent.setValue(text);
    }

    public void hideLoding() {
        ui.hideLoadingEvent.call();
    }


    public void startActivityForResult(Class<?> cls, Bundle bundle, int requestCode) {
        Map<String, Object> params = new HashMap<>();
        params.put(BaseViewModel.ParameterField.CLASS, cls);
        if (bundle != null) {
            params.put(BaseViewModel.ParameterField.BUNDLE, bundle);
        }

        params.put(BaseViewModel.ParameterField.REQUESTCODE, requestCode);
        this.ui.startActivityEvent.postValue(params);
    }


    public void finish() {
        ui.finishEvent.call();
    }

    public void onBackPressed() {
        ui.onBackPressedEvent.call();
    }


    public static final class ParameterField {
        public static String CLASS = "CLASS";
        public static String BUNDLE = "BUNDLE";
        public static String REQUESTCODE = "REQUESTCODE";

        public ParameterField() {
        }
    }

    public static final class UIChangeLiveData {
        private SingleLiveEvent<Void> finishEvent;
        private SingleLiveEvent<Void> onBackPressedEvent;
        private SingleLiveEvent<Map<String, Object>> startActivityEvent;
        private SingleLiveEvent<Map<String, Object>> startActivityForResultEvent;
        private SingleLiveEvent<String> showLoadingEvent;

        private SingleLiveEvent<Void> hideLoadingEvent;

        public SingleLiveEvent<String> getShowLoadingEvent() {
            return showLoadingEvent = createLiveData(showLoadingEvent);
        }

        public SingleLiveEvent<Void> getHideLoadingEvent() {
            return hideLoadingEvent = createLiveData(hideLoadingEvent);
        }


        public SingleLiveEvent<Void> getFinishEvent() {
            return finishEvent = createLiveData(finishEvent);
        }

        public SingleLiveEvent<Void> getOnBackPressedEvent() {
            return onBackPressedEvent = createLiveData(onBackPressedEvent);
        }

        public SingleLiveEvent<Map<String, Object>> getStartActivityEvent() {
            return startActivityEvent = createLiveData(startActivityEvent);
        }

        public SingleLiveEvent<Map<String, Object>> getStartActivityForResultEvent() {
            return startActivityForResultEvent = createLiveData(startActivityForResultEvent);
        }


        private <T> SingleLiveEvent<T> createLiveData(SingleLiveEvent<T> liveData) {
            if (liveData == null) {
                liveData = new SingleLiveEvent<T>();
            }

            return liveData;
        }
    }
}
