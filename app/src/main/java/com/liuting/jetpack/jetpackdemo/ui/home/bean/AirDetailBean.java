package com.liuting.jetpack.jetpackdemo.ui.home.bean;

import java.util.List;

/**
 * 作者:admin on 2020/10/24 21:12
 * 邮箱:474211389@qq.com
 * 项目名：JetpackDemo
 * 包名：com.liuting.jetpack.jetpackdemo.ui.home.bean
 * TODO:
 */
public class AirDetailBean {


    /**
     * city : 苏州
     * future : [{"date":"2019-02-22","direct":"北风转西北风","temperature":"1/7℃","weather":"小雨转多云","wid":{"day":"07","night":"01"}},{"date":"2019-02-23","direct":"北风转东北风","temperature":"2/11℃","weather":"多云转阴","wid":{"day":"01","night":"02"}},{"date":"2019-02-24","direct":"东北风转北风","temperature":"6/12℃","weather":"多云","wid":{"day":"01","night":"01"}},{"date":"2019-02-25","direct":"东北风","temperature":"5/12℃","weather":"小雨转多云","wid":{"day":"07","night":"01"}},{"date":"2019-02-26","direct":"东北风","temperature":"5/11℃","weather":"多云转小雨","wid":{"day":"01","night":"07"}}]
     * realtime : {"aqi":"80","direct":"西北风","humidity":"82","info":"阴","power":"3级","temperature":"4","wid":"02"}
     */

    private String city;
    /**
     * aqi : 80
     * direct : 西北风
     * humidity : 82
     * info : 阴
     * power : 3级
     * temperature : 4
     * wid : 02
     */

    private RealtimeBean realtime;
    /**
     * date : 2019-02-22
     * direct : 北风转西北风
     * temperature : 1/7℃
     * weather : 小雨转多云
     * wid : {"day":"07","night":"01"}
     */

    private List<FutureBean> future;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public RealtimeBean getRealtime() {
        return realtime;
    }

    public void setRealtime(RealtimeBean realtime) {
        this.realtime = realtime;
    }

    public List<FutureBean> getFuture() {
        return future;
    }

    public void setFuture(List<FutureBean> future) {
        this.future = future;
    }

    public static class RealtimeBean {
        private String aqi;
        private String direct;
        private String humidity;
        private String info;
        private String power;
        private String temperature;
        private String wid;

        public String getAqi() {
            return aqi;
        }

        public void setAqi(String aqi) {
            this.aqi = aqi;
        }

        public String getDirect() {
            return direct;
        }

        public void setDirect(String direct) {
            this.direct = direct;
        }

        public String getHumidity() {
            return humidity;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getPower() {
            return power;
        }

        public void setPower(String power) {
            this.power = power;
        }

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        public String getWid() {
            return wid;
        }

        public void setWid(String wid) {
            this.wid = wid;
        }
    }

    public static class FutureBean {
        private String date;
        private String direct;
        private String temperature;
        private String weather;
        /**
         * day : 07
         * night : 01
         */

        private WidBean wid;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDirect() {
            return direct;
        }

        public void setDirect(String direct) {
            this.direct = direct;
        }

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        public String getWeather() {
            return weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        public WidBean getWid() {
            return wid;
        }

        public void setWid(WidBean wid) {
            this.wid = wid;
        }

        public static class WidBean {
            private String day;
            private String night;

            public String getDay() {
                return day;
            }

            public void setDay(String day) {
                this.day = day;
            }

            public String getNight() {
                return night;
            }

            public void setNight(String night) {
                this.night = night;
            }
        }
    }
}
