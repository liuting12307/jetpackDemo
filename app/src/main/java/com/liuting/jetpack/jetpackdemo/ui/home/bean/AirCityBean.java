package com.liuting.jetpack.jetpackdemo.ui.home.bean;

import androidx.databinding.BaseObservable;

/**
 * 作者:admin on 2020/10/19 23:50
 * 邮箱:474211389@qq.com
 * 项目名：JetpackDemo
 * 包名：com.liuting.jetpack.jetpackdemo.ui.home
 * TODO:
 */
public class AirCityBean extends BaseObservable {

    private String city;
    private String district;
    private int id;
    private String province;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
