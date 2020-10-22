package com.liuting.jetpack.jetpackdemo.base.basebindingadapter;

import android.view.View;
import android.widget.ListView;

import com.liuting.jetpack.jetpackdemo.base.BindingCommand;

import androidx.databinding.BindingAdapter;

/**
 * 作者:admin on 2020/10/17 17:54
 * 邮箱:474211389@qq.com
 * 项目名：JetpackDemo
 * 包名：com.liuting.jetpack.jetpackdemo.base
 * TODO:
 */
public class BaseBidingAdapter {
    @BindingAdapter(value ="onClickCommand", requireAll = false)
    public static void setOnClickCommand(View view, final BindingCommand<View> bindingCommand ) {
        view.setOnClickListener(bindingCommand::execute);
    }
}
