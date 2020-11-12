package com.liuting.jetpack.jetpackdemo.ui.home;

import com.liuting.jetpack.jetpackdemo.R;
import com.liuting.jetpack.jetpackdemo.base.BaseMVVMFragment;
import com.liuting.jetpack.jetpackdemo.databinding.FragmentHomeBinding;
import com.liuting.jetpack.jetpackdemo.ui.home.adapter.AirCityAdapter;
import com.liuting.jetpack.jetpackdemo.ui.home.bean.AirCityBean;

import java.util.ArrayList;

import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.LinearLayoutManager;

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