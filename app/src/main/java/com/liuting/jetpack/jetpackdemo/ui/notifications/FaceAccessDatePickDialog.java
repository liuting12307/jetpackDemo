package com.liuting.jetpack.jetpackdemo.ui.notifications;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.liuting.jetpack.jetpackdemo.R;
import com.liuting.jetpack.jetpackdemo.view.wheelview.IWheelviewAdapter;
import com.liuting.jetpack.jetpackdemo.view.wheelview.WheelView;
import com.liuting.jetpack.jetpackdemo.view.wheelview.WheelviewAdapter;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;

import androidx.annotation.NonNull;

/**
 * 作者:admin on 2020/11/12 23:41
 * 邮箱:474211389@qq.com
 * 项目名：JetpackDemo
 * 包名：com.liuting.jetpack.jetpackdemo.ui.notifications
 * TODO:
 */
public class FaceAccessDatePickDialog extends Dialog {

    private WheelView mYearWheelView;
    private WheelView mMonthWheelView;
    private WheelView mDayWheelView;
    private String[] provides = {"天津市", "北京市", "黑龙江省", "江苏省", "浙江省", "安徽省",
            "福建省", "江西省", "山东省", "河南省", "湖北省", "湖南省", "广东省"};

    public FaceAccessDatePickDialog(@NonNull Context context) {
        super(context, R.style.common_dalog);
        setContentView(R.layout.dialog_faceaccess_datepickdialog);
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity= Gravity.BOTTOM;
        params.width= WindowManager.LayoutParams.MATCH_PARENT;
        params.height=WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(params);
        initView();
        initData();
    }

    private void initData() {
        ArrayList<String> provider = new ArrayList<>(Arrays.asList(provides));
        IWheelviewAdapter providerAdapter = new WheelviewAdapter(provider);
        mYearWheelView.setAdapter(providerAdapter);
        // 设置滚动选择监听
        mYearWheelView.setWheelScrollListener(new WheelView.WheelScrollListener() {

            @Override
            public void changed(int selected, @Nullable Object name) {
                Log.d("lt",name + "被选中了第" + selected);
            }

        });
        mMonthWheelView.setAdapter(providerAdapter);
        // 设置滚动选择监听
        mMonthWheelView.setWheelScrollListener(new WheelView.WheelScrollListener() {

            @Override
            public void changed(int selected, @Nullable Object name) {
                Log.d("lt",name + "被选中了第" + selected);
            }

        });
        mDayWheelView.setAdapter(providerAdapter);
        // 设置滚动选择监听
        mDayWheelView.setWheelScrollListener(new WheelView.WheelScrollListener() {

            @Override
            public void changed(int selected, @Nullable Object name) {
                Log.d("lt",name + "被选中了第" + selected);
            }

        });
    }

    private void initView() {
        mYearWheelView = findViewById(R.id.year_wheelview);
        mMonthWheelView = findViewById(R.id.month_wheelview);
        mDayWheelView = findViewById(R.id.day_wheelview);
    }
}
