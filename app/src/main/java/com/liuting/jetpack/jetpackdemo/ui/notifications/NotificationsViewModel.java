package com.liuting.jetpack.jetpackdemo.ui.notifications;

import android.view.View;

import com.liuting.jetpack.jetpackdemo.base.BaseViewModel;
import com.liuting.jetpack.jetpackdemo.base.BindingCommand;
import com.liuting.jetpack.jetpackdemo.base.basebindingadapter.BindingAction;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotificationsViewModel extends BaseViewModel {

    public MutableLiveData<Boolean> dateClickLiveData=new MutableLiveData<>(false);
    public BindingCommand<View> dateCommand = new BindingCommand<>(var1 -> {
        dateClickLiveData.setValue(true);
    });
}