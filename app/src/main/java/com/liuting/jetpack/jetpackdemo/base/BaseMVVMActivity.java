package com.liuting.jetpack.jetpackdemo.base;

import android.content.Intent;
import android.os.Bundle;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * 作者:admin on 2020/10/17 11:56
 * 邮箱:474211389@qq.com
 * 项目名：JetpackDemo
 * 包名：com.liuting.jetpack.jetpackdemo.base
 * TODO:
 */
public abstract class BaseMVVMActivity<DB extends ViewDataBinding, VM extends BaseViewModel> extends AppCompatActivity {
    protected DB binding;
    protected VM viewModel;
    private int viewModelId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewDataBinding();
        initViewObservable();
        initData();
        registerUIChangeLiveDateCallBack();
    }

    protected abstract void initData();

    protected abstract void initViewObservable();

    private void initViewDataBinding() {
        binding = DataBindingUtil.setContentView(this, getContentViewLayoutId());
        viewModel = initViewModel();
        viewModel.inject(this);
        viewModelId = getViewModelId();

        binding.setVariable(getViewModelId(), viewModel);
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

    private void registerUIChangeLiveDateCallBack() {
        viewModel.getUi().getFinishEvent().observe(this, (v) -> {
            finish();
        });
        viewModel.getUi().getOnBackPressedEvent().observe(this, (v) -> {
            onBackPressed();
        });
        viewModel.getUi().getStartActivityEvent().observe(this, (params) -> {
            Class<?> cls = (Class) params.get(BaseViewModel.ParameterField.CLASS);
            Bundle bundle = (Bundle) params.get(BaseViewModel.ParameterField.BUNDLE);
            startActivity(cls, bundle);
        });
        viewModel.getUi().getStartActivityForResultEvent().observe(this, (params) -> {
            Class<?> cls = (Class) params.get(BaseViewModel.ParameterField.CLASS);
            Bundle bundle = (Bundle) params.get(BaseViewModel.ParameterField.BUNDLE);
            int requestCode = (Integer) params.get(BaseViewModel.ParameterField.REQUESTCODE);
            startActivityForResult(cls, bundle, requestCode);
        });

    }

    public void startActivity(Class<?> cls) {
        this.startActivity(cls, (Bundle) null);
    }

    public void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public void startActivityForResult(Class<?> cls, Bundle bundle, int requestCode) {
        Intent intent = new Intent(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);

    }

    protected abstract int getViewModelId();

    public abstract int getContentViewLayoutId();
}
