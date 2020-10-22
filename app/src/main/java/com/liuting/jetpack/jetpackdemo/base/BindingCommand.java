package com.liuting.jetpack.jetpackdemo.base;

import com.liuting.jetpack.jetpackdemo.base.basebindingadapter.BindingAction;
import com.liuting.jetpack.jetpackdemo.base.basebindingadapter.BindingConsumer;
import com.liuting.jetpack.jetpackdemo.base.basebindingadapter.BindingFunction;

/**
 * 作者:admin on 2020/10/17 18:35
 * 邮箱:474211389@qq.com
 * 项目名：JetpackDemo
 * 包名：com.liuting.jetpack.jetpackdemo.base
 * TODO:
 */
public class BindingCommand<T> {
    private BindingAction execute;
    private BindingConsumer<T> consumer;
    private BindingFunction<Boolean> canExecute;

    public BindingCommand(BindingAction execute) {
        this.execute = execute;
    }

    public BindingCommand(BindingConsumer<T> execute) {
        this.consumer = execute;
    }

    public BindingCommand(BindingAction execute, BindingFunction<Boolean> canExecute) {
        this.execute = execute;
        this.canExecute = canExecute;
    }

    public BindingCommand(BindingConsumer<T> execute, BindingFunction<Boolean> canExecute0) {
        this.consumer = execute;
        this.canExecute = canExecute0;
    }

    public boolean canExecute() {
        return this.canExecute == null ? true : (Boolean)this.canExecute.call();
    }

    public void execute() {
        if (this.execute != null && this.canExecute()) {
            this.execute.call();
        }

    }

    public void execute(T parameter) {
        if (this.consumer != null && this.canExecute()) {
            this.consumer.call(parameter);
        }

    }
}
