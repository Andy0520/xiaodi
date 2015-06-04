package com.example.andy.xiaodi;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends Activity {
    private Bean bean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            HttpURLConnection conn=null;
            String sb="";
            @Override
            public void run() {
                try {
                    URL url=new URL("http://192.168.1.101/person.json");
                    conn = (HttpURLConnection) url.openConnection();
                    conn.setConnectTimeout(5000);
                    conn.setRequestMethod("GET");
                    InputStream is=conn.getInputStream();
                    InputStreamReader isr=new InputStreamReader(is);
                    BufferedReader buff=new BufferedReader(isr);
                    String line="";
                    while((line=buff.readLine())!=null){
                        sb+=line;
                    }
                    buff.close();
                    is.close();
                    Log.d("TAG",sb);
                    Gson gson=new Gson();
                    bean=gson.fromJson(sb,Bean.class);
                    Log.d("Andy",bean.getStatus());
                    Log.d("Andy",bean.getResults().get(0).getWeather_data().get(0).getWeather());
//                    Log.d("Andy",bean.new ResultsEntity().getCurrentCity());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

}
