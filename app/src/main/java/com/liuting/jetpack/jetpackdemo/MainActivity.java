package com.liuting.jetpack.jetpackdemo;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.liuting.jetpack.jetpackdemo.network.NetEntry;


import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);
        RxJavaPlugins.setErrorHandler(throwable -> {
            throwable.printStackTrace();//这里处理所有的Rxjava异常
        });
    }

}