package com.liuting.jetpack.jetpackdemo.ui.home;

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
import androidx.recyclerview.widget.LinearLayoutManager;

import com.liuting.jetpack.jetpackdemo.R;
import com.liuting.jetpack.jetpackdemo.base.BaseMVVMFragment;
import com.liuting.jetpack.jetpackdemo.databinding.FragmentHomeBinding;
import com.liuting.jetpack.jetpackdemo.ui.dashboard.adapter.NewsAdapter;
import com.liuting.jetpack.jetpackdemo.ui.dashboard.bean.NewsBean;
import com.liuting.jetpack.jetpackdemo.ui.home.adapter.AirCityAdapter;
import com.liuting.jetpack.jetpackdemo.ui.home.bean.AirCityBean;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseMVVMFragment<FragmentHomeBinding,HomeViewModel> {

    private ArrayList<AirCityBean> mList;
    private AirCityAdapter mAirCityAdapter;
    @Override
    protected void initData() {
        mList=new ArrayList<>();
        mAirCityAdapter = new AirCityAdapter(getActivity(),mList);
        binding.recyclerview.setAdapter(mAirCityAdapter);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        viewModel.getAirCitys();
    }

    @Override
    protected void initViewObservable() {
        viewModel.getListMutableLiveData().observe(this, airCityBeans -> {
            mAirCityAdapter.addList(airCityBeans);
        });
    }

    @Override
    protected int getViewModelId() {
        return BR.viewModel;
    }

    @Override
    public int getContentViewLayoutId() {
        return R.layout.fragment_home;
    }
}