package com.liuting.jetpack.jetpackdemo.ui.notifications;

import com.liuting.jetpack.jetpackdemo.R;
import com.liuting.jetpack.jetpackdemo.base.BaseMVVMFragment;
import com.liuting.jetpack.jetpackdemo.databinding.FragmentNotificationsBinding;

import androidx.databinding.library.baseAdapters.BR;

public class NotificationsFragment extends BaseMVVMFragment<FragmentNotificationsBinding,NotificationsViewModel> {


    @Override
    protected void initData() {

    }

    @Override
    protected void initViewObservable() {

    }

    @Override
    protected int getViewModelId() {
        return BR.viewModel;
    }

    @Override
    public int getContentViewLayoutId() {
        return R.layout.fragment_notifications;
    }
}