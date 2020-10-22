package com.liuting.jetpack.jetpackdemo.viewmodel;

import android.os.Build;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者:admin on 2020/9/9 00:12
 * 邮箱:474211389@qq.com
 * 项目名：JetpackDemo
 * 包名：com.liuting.jetpack.jetpackdemo.viewmodel
 * TODO:
 */
public class MainViewModel extends ViewModel {

    private String TAG="MainViewModel";
    private int count=1;
    private MutableLiveData<String> currentName;

    public MutableLiveData<String> getCurrentName() {
        if (currentName == null) {
            currentName = new MutableLiveData<>();
        }
        return currentName;
    }

    public void testRxjava(){
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("1");
                emitter.onNext("2");
                emitter.onNext("3");
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe");
            }
            @Override
            public void onNext(String s) {
                Log.d(TAG, "onNext : " + s);
            }
            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError : " + e.toString());
            }
            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
            }
        });

    }
    public void updateCurrentName(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(++count<10){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    getCurrentName().postValue("name--"+count);
                }
            }
        }).start();
    }
}
