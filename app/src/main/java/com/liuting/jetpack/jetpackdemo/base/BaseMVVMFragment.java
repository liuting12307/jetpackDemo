package com.liuting.jetpack.jetpackdemo.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

/**
 * 作者:admin on 2020/10/18 13:24
 * 邮箱:474211389@qq.com
 * 项目名：JetpackDemo
 * 包名：com.liuting.jetpack.jetpackdemo.base
 * TODO:
 */
public abstract class BaseMVVMFragment<DB extends ViewDataBinding, VM extends BaseViewModel> extends Fragment {
    protected DB binding;
    protected VM viewModel;
    private int viewModelId;
    protected boolean bIsViewCreated;
    protected boolean bIsDataLoaded;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater,getContentViewLayoutId(),container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.bIsViewCreated = true;
        initViewDataBinding();
        registerUIChangeLiveDataCallback();
        initViewObservable();
        initData();
        if (this.getUserVisibleHint() && !this.bIsDataLoaded) {
            this.loadData();
            this.bIsDataLoaded = true;
        }
    }

    protected abstract void initData();

    protected abstract void initViewObservable();

    protected abstract int getViewModelId();

    public abstract int getContentViewLayoutId();

    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && this.bIsViewCreated && !this.bIsDataLoaded) {
            this.loadData();
            this.bIsDataLoaded = true;
        }

    }

    public void loadData() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (binding != null) {
            binding.unbind();
        }

        bIsViewCreated = false;
        bIsDataLoaded = false;
    }

    public void initViewDataBinding() {
        viewModel = initViewModel();
        viewModelId = this.getViewModelId();
        viewModel.inject(getActivity());
        binding.setVariable(viewModelId, viewModel);

    }

    private VM initViewModel() {
        Type type = this.getClass().getGenericSuperclass();
        Class modelClass;
        if (type instanceof ParameterizedType) {
            modelClass = (Class) ((ParameterizedType) type).getActualTypeArguments()[1];
        } else {
            modelClass = BaseViewModel.class;
        }
        return (VM) new ViewModelProvider(this).get(modelClass);

    }

    public void registerUIChangeLiveDataCallback() {
        viewModel.getUi().getFinishEvent().observe(this, (v) -> {
            if (!isFinish()) {
                getActivity().finish();
            }
        });

        viewModel.getUi().getStartActivityEvent().observe(this, (params) -> {
            Class<?> cls = (Class)params.get(BaseViewModel.ParameterField.CLASS);
            Bundle bundle = (Bundle)params.get(BaseViewModel.ParameterField.BUNDLE);
            startActivity(cls, bundle);
        });
        viewModel.getUi().getStartActivityForResultEvent().observe(this, (params) -> {
            Class<?> cls = (Class)params.get(BaseViewModel.ParameterField.CLASS);
            Bundle bundle = (Bundle)params.get(BaseViewModel.ParameterField.BUNDLE);
            int requestCode = (Integer)params.get(BaseViewModel.ParameterField.REQUESTCODE);
            startActivityForResult(cls, bundle, requestCode);
        });
        viewModel.getUi().getshowLoadingEvent().observe(this, s -> {
            Toast.makeText(getActivity(),s,Toast.LENGTH_SHORT).show();
        });

    }

    public boolean isFinish() {
        return this.getActivity() == null || this.getActivity().isDestroyed();
    }

    public void startActivity(Class<?> clz) {
        this.startActivity(new Intent(getActivity(), clz));
    }

    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent(getActivity(), clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }

        this.startActivity(intent);
    }

    public void startActivityForResult(Class<?> cls, Bundle bundle, int requestCode) {
        Intent intent = new Intent(getActivity(), cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);

    }

}
