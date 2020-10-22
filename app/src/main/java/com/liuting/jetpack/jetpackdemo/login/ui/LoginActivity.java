package com.liuting.jetpack.jetpackdemo.login.ui;

import com.liuting.jetpack.jetpackdemo.BR;
import com.liuting.jetpack.jetpackdemo.R;
import com.liuting.jetpack.jetpackdemo.base.BaseMVVMActivity;
import com.liuting.jetpack.jetpackdemo.databinding.ActivityLoginBinding;
import com.liuting.jetpack.jetpackdemo.login.viewmodel.LoginViewModel;

/**
 * 作者:admin on 2020/10/17 11:55
 * 邮箱:474211389@qq.com
 * 项目名：JetpackDemo
 * 包名：com.liuting.jetpack.jetpackdemo
 * TODO:
 */
public class LoginActivity extends BaseMVVMActivity<ActivityLoginBinding, LoginViewModel> {
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
        return R.layout.activity_login;
    }
}
