package com.liuting.jetpack.jetpackdemo.login.viewmodel;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.liuting.jetpack.jetpackdemo.MainActivity;
import com.liuting.jetpack.jetpackdemo.base.BaseViewModel;
import com.liuting.jetpack.jetpackdemo.base.BindingCommand;
import com.liuting.jetpack.jetpackdemo.base.basebindingadapter.BindingConsumer;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

/**
 * 作者:admin on 2020/10/17 12:55
 * 邮箱:474211389@qq.com
 * 项目名：JetpackDemo
 * 包名：com.liuting.jetpack.jetpackdemo.viewmodel
 * TODO:
 */
public class LoginViewModel extends BaseViewModel {
   private String TAG=getClass().getSimpleName();
    public ObservableField<String> mUserName=new ObservableField<>("123");
    public ObservableField<String> mPassword=new ObservableField<>("123");


    public BindingCommand<View> loginCommand = new BindingCommand<>(var1 -> {
        login();
    });
    public BindingCommand<View> loginCommand2 = new BindingCommand<>( var1 -> finish());

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public void login(){
        String useName=mUserName.get();
        String password=mPassword.get();
        Log.d(TAG,"useName="+useName);
        Log.d(TAG,"password="+password);
        if(TextUtils.isEmpty(useName)){
            Toast.makeText(getApplication(),"用户名不能为空",Toast.LENGTH_SHORT).show();
            return ;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(getApplication(),"密码不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        if(useName.equals("123")&&password.equals("123")){
            Log.d(TAG,"登录成功");
            startActivity(MainActivity.class);
        }else{
            Toast.makeText(getApplication(),"用户名或密码错误",Toast.LENGTH_SHORT).show();
        }
    }
}
