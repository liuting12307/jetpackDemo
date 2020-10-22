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
public class BaseViewModel extends ViewModel {
    protected Context mContext;
    private BaseViewModel.UIChangeLiveData ui;
    protected void inject(Context context){
        mContext=context;
    }

    public BaseViewModel.UIChangeLiveData getUi() {
        if (this.ui == null) {
            this.ui = new BaseViewModel.UIChangeLiveData();
        }

        return this.ui;
    }

    public void startActivity(Class<?> cls) {
        this.startActivity(cls, (Bundle)null);
    }

    public void startActivity(Class<?> cls, Bundle bundle) {
        Map<String, Object> params = new HashMap();
        params.put(BaseViewModel.ParameterField.CLASS, cls);
        if (bundle != null) {
            params.put(BaseViewModel.ParameterField.BUNDLE, bundle);
        }

        this.ui.startActivityEvent.postValue(params);
    }



    public void startActivityForResult(Class<?> cls, Bundle bundle, int requestCode) {
        Map<String, Object> params = new HashMap();
        params.put(BaseViewModel.ParameterField.CLASS, cls);
        if (bundle != null) {
            params.put(BaseViewModel.ParameterField.BUNDLE, bundle);
        }

        params.put(BaseViewModel.ParameterField.REQUESTCODE, requestCode);
        this.ui.startActivityEvent.postValue(params);
    }


    public void finish() {
        this.ui.finishEvent.call();
    }

    public void onBackPressed() {
        this.ui.onBackPressedEvent.call();
    }


    public static final class ParameterField {
        public static String CLASS = "CLASS";
        public static String BUNDLE = "BUNDLE";
        public static String REQUESTCODE = "REQUESTCODE";

        public ParameterField() {
        }
    }

    public final class UIChangeLiveData {
        private SingleLiveEvent<Void> finishEvent;
        private SingleLiveEvent<Void> onBackPressedEvent;
        private SingleLiveEvent<Map<String, Object>> startActivityEvent;
        private SingleLiveEvent<Map<String, Object>> startActivityForResultEvent;


        public SingleLiveEvent<Void> getFinishEvent() {
            return this.finishEvent = createLiveData(this.finishEvent);
        }

        public SingleLiveEvent<Void> getOnBackPressedEvent() {
            return this.onBackPressedEvent = createLiveData(this.onBackPressedEvent);
        }

        public SingleLiveEvent<Map<String, Object>> getStartActivityEvent() {
            return this.startActivityEvent = createLiveData(this.startActivityEvent);
        }

        public SingleLiveEvent<Map<String, Object>> getStartActivityForResultEvent() {
            return this.startActivityForResultEvent = createLiveData(this.startActivityForResultEvent);
        }


        private <T> SingleLiveEvent<T>  createLiveData(SingleLiveEvent<T> liveData) {
            if (liveData == null) {
                liveData = new SingleLiveEvent<T>();
            }

            return liveData;
        }
    }
}
