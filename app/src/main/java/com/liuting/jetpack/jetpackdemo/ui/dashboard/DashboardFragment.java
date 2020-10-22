package com.liuting.jetpack.jetpackdemo.ui.dashboard;

import com.liuting.jetpack.jetpackdemo.R;
import com.liuting.jetpack.jetpackdemo.base.BaseMVVMFragment;
import com.liuting.jetpack.jetpackdemo.databinding.FragmentDashboardBinding;
import com.liuting.jetpack.jetpackdemo.ui.dashboard.adapter.NewsAdapter;
import com.liuting.jetpack.jetpackdemo.ui.dashboard.bean.NewsBean;

import java.util.ArrayList;

import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.LinearLayoutManager;

public class DashboardFragment extends BaseMVVMFragment<FragmentDashboardBinding,DashboardViewModel> {

    private String TAG=getClass().getSimpleName();
    private ArrayList<NewsBean> mList;
    private NewsAdapter mNewsAdapter;

    @Override
    protected void initData() {
        mList=new ArrayList<>();
        mNewsAdapter = new NewsAdapter(getActivity(),mList);
        binding.recyclerview.setAdapter(mNewsAdapter);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        viewModel.getTopNews();
    }

    @Override
    protected void initViewObservable() {
        viewModel.getListMutableLiveData().observe(this,newsBeans -> mNewsAdapter.addList(newsBeans));
    }

    @Override
    protected int getViewModelId() {
        return BR.viewModel;
    }

    @Override
    public int getContentViewLayoutId() {
        return R.layout.fragment_dashboard;
    }
}