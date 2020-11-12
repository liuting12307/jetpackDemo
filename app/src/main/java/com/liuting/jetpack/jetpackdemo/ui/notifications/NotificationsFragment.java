package com.liuting.jetpack.jetpackdemo.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.library.baseAdapters.BR;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.liuting.jetpack.jetpackdemo.R;
import com.liuting.jetpack.jetpackdemo.base.BaseMVVMFragment;
import com.liuting.jetpack.jetpackdemo.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends BaseMVVMFragment<FragmentNotificationsBinding,NotificationsViewModel> {


    @Override
    protected void initData() {

    }

    @Override
    protected void initViewObservable() {
        binding.textNotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FaceAccessDatePickDialog faceAccessDatePickDialog=new FaceAccessDatePickDialog(getContext());
                faceAccessDatePickDialog.show();
            }
        });
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