package com.example.andy.xiaodi;

import java.util.List;

/**
 * Created by Andy on 2015/6/3.
 */
public class Bean {

    /**
     * date : 2014-05-10
     * error : 0
     * results : [{"weather_data":[{"date":"周六(今天, 实时：19℃)","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/dayu.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/dayu.png","weather":"大雨","temperature":"18℃","wind":"东南风5-6级"},{"date":"周日","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/zhenyu.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/duoyun.png","weather":"阵雨转多云","temperature":"21 ~ 14℃","wind":"西北风4-5级"}],"currentCity":"南京"}]
     * status : success
     */
    private String date;
    private int error;
    private List<ResultsEntity> results;
    private String status;

    public void setDate(String date) {
        this.date = date;
    }

    public void setError(int error) {
        this.error = error;
    }

    public void setResults(List<ResultsEntity> results) {
        this.results = results;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public int getError() {
        return error;
    }

    public List<ResultsEntity> getResults() {
        return results;
    }

    public String getStatus() {
        return status;
    }

    public class ResultsEntity {
        /**
         * weather_data : [{"date":"周六(今天, 实时：19℃)","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/dayu.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/dayu.png","weather":"大雨","temperature":"18℃","wind":"东南风5-6级"},{"date":"周日","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/zhenyu.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/duoyun.png","weather":"阵雨转多云","temperature":"21 ~ 14℃","wind":"西北风4-5级"}]
         * currentCity : 南京
         */
        private List<Weather_dataEntity> weather_data;
        private String currentCity;

        public void setWeather_data(List<Weather_dataEntity> weather_data) {
            this.weather_data = weather_data;
        }

        public void setCurrentCity(String currentCity) {
            this.currentCity = currentCity;
        }

        public List<Weather_dataEntity> getWeather_data() {
            return weather_data;
        }

        public String getCurrentCity() {
            return currentCity;
        }

        public class Weather_dataEntity {
            /**
             * date : 周六(今天, 实时：19℃)
             * dayPictureUrl : http://api.map.baidu.com/images/weather/day/dayu.png
             * nightPictureUrl : http://api.map.baidu.com/images/weather/night/dayu.png
             * weather : 大雨
             * temperature : 18℃
             * wind : 东南风5-6级
             */
            private String date;
            private String dayPictureUrl;
            private String nightPictureUrl;
            private String weather;
            private String temperature;
            private String wind;

            public void setDate(String date) {
                this.date = date;
            }

            public void setDayPictureUrl(String dayPictureUrl) {
                this.dayPictureUrl = dayPictureUrl;
            }

            public void setNightPictureUrl(String nightPictureUrl) {
                this.nightPictureUrl = nightPictureUrl;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public void setWind(String wind) {
                this.wind = wind;
            }

            public String getDate() {
                return date;
            }

            public String getDayPictureUrl() {
                return dayPictureUrl;
            }

            public String getNightPictureUrl() {
                return nightPictureUrl;
            }

            public String getWeather() {
                return weather;
            }

            public String getTemperature() {
                return temperature;
            }

            public String getWind() {
                return wind;
            }
        }
    }
}
