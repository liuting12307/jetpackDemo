package com.liuting.jetpack.jetpackdemo.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.liuting.jetpack.jetpackdemo.R;
import com.liuting.jetpack.jetpackdemo.ui.notifications.xrecyclerview.AlphaChangeActivity;
import com.liuting.jetpack.jetpackdemo.ui.notifications.xrecyclerview.CollapsingToolbarLayoutActivity;
import com.liuting.jetpack.jetpackdemo.ui.notifications.xrecyclerview.DisableExampleActivity;
import com.liuting.jetpack.jetpackdemo.ui.notifications.xrecyclerview.EmptyViewActivity;
import com.liuting.jetpack.jetpackdemo.ui.notifications.xrecyclerview.GridActivity;
import com.liuting.jetpack.jetpackdemo.ui.notifications.xrecyclerview.ItemDecorationActivity;
import com.liuting.jetpack.jetpackdemo.ui.notifications.xrecyclerview.LinearActivity;
import com.liuting.jetpack.jetpackdemo.ui.notifications.xrecyclerview.LinearStickyScrollActivity;
import com.liuting.jetpack.jetpackdemo.ui.notifications.xrecyclerview.MultiHeaderActivity;
import com.liuting.jetpack.jetpackdemo.ui.notifications.xrecyclerview.StaggeredGridActivity;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 作者:admin on 2021/3/21 21:41
 * 邮箱:474211389@qq.com
 * 项目名：JetpackDemo
 * 包名：com.liuting.jetpack.jetpackdemo.ui.notifications
 * TODO:
 */
public class XRecyclerViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xrecyclerview);
    }

    public void gotoStickyScrollLinearActivity(View v){
        Intent intent = new Intent();
        intent.setClass(this, LinearStickyScrollActivity.class);
        startActivity(intent);
    }

    public void gotoLinearActivity(View v) {
        Intent intent = new Intent();
        intent.setClass(this, LinearActivity.class);
        startActivity(intent);
    }
    public void gotoGridActivity(View v) {
        Intent intent = new Intent();
        intent.setClass(this, GridActivity.class);
        startActivity(intent);
    }
    public void gotoStaggeredGridActivity(View v) {
        Intent intent = new Intent();
        intent.setClass(this, StaggeredGridActivity.class);
        startActivity(intent);
    }

    public void gotoEmptyViewActivity(View v) {
        Intent intent = new Intent();
        intent.setClass(this, EmptyViewActivity.class);
        startActivity(intent);
    }

    public void gotoCollapsingToolbarLayoutActivity(View v) {
        Intent intent = new Intent();
        intent.setClass(this, CollapsingToolbarLayoutActivity.class);
        startActivity(intent);
    }

    public void gotoDisableExampleActivity(View v) {
        Intent intent = new Intent();
        intent.setClass(this, DisableExampleActivity.class);
        startActivity(intent);
    }

    public void gotoMultiHeaderActivity(View v) {
        Intent intent = new Intent();
        intent.setClass(this, MultiHeaderActivity.class);
        startActivity(intent);
    }
    public void gotoItemDecorationActivity(View v) {
        Intent intent = new Intent();
        intent.setClass(this, ItemDecorationActivity.class);
        startActivity(intent);
    }


    public void gotoItemAlphaChangeActivity(View view) {
        Intent intent = new Intent();
        intent.setClass(this, AlphaChangeActivity.class);
        startActivity(intent);
    }
}
